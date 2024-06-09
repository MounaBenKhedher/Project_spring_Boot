package com.example.project.service;


import com.example.project.exception.MissingEntity;
import com.example.project.model.Client;
import com.example.project.model.ClientSni;
import com.example.project.repository.ClienRepository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class ClientService {
    @Autowired
    ClienRepository clienRepository;


    public List<Client> getAllClient() {
        return clienRepository.findAll();
    }
    public Client findById(long id) throws MissingEntity {
        Optional<Client> client= clienRepository.findById(id);
        if(!client.isPresent()){
            throw new MissingEntity("Menue not found with code Menu : "+id);
        }
        return client.get();
    }

    public Map<String, Boolean> deleteclient(long id) throws MissingEntity {
        Client client = findById(id);
        clienRepository.delete(client);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }
    public Client updateClient(long id, Client clientDetails) {
        return clienRepository.findById(id).map(client -> {
            client.setCodeRelation(clientDetails.getCodeRelation());
            client.setIdNat(clientDetails.getIdNat());
            client.setCodeRelationFlexcube(clientDetails.getCodeRelationFlexcube());
            client.setIdentifiantProspect(clientDetails.getIdentifiantProspect());
            client.setDenomination(clientDetails.getDenomination());
            client.setProfession(clientDetails.getProfession());
            client.setAdresse(clientDetails.getAdresse());
            client.setAgence(clientDetails.getAgence());
            client.setVille(clientDetails.getVille());
            client.setRegion(clientDetails.getRegion());
            client.setDateNaissance(clientDetails.getDateNaissance());
            client.setDateDebutRelation(clientDetails.getDateDebutRelation());
            client.setAutre(clientDetails.getAutre());
            return clienRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    public Optional<Client> findClientByCodeRelation(long codeRelation) {
        return clienRepository.findByCodeRelation(codeRelation);
    }
    public Optional<Client> findClientById(long id) {
        return clienRepository.findById(id);
    }
    @Transactional
    public Set<Client> uploadClients(MultipartFile file) throws IOException {
        Set<ClientSni> clients = parseCsv(file);
        Set<Client> updatedClients = new HashSet<>();

        for (ClientSni client : clients) {
            Optional<Client> existingClientOptional = clienRepository.findByCodeRelationAndIdNat(client.getCodeRelation(), client.getIdNat());
            if (existingClientOptional.isPresent()) {
                Client existingClient = existingClientOptional.get();

                if (existingClient instanceof ClientSni) {
                    ClientSni existingClientSni = (ClientSni) existingClient;

                    existingClientSni.setAdresse(client.getAdresse());
                    existingClient.setAgence(client.getAgence());
                    existingClient.setAutre(client.getAutre());

                    existingClient.setCodeRelation(client.getCodeRelation());
                    existingClient.setCodeRelationFlexcube(client.getCodeRelationFlexcube());
                    existingClient.setDateDebutRelation(client.getDateDebutRelation());
                    existingClient.setDateNaissance(client.getDateNaissance());
                    existingClient.setIdNat(client.getIdNat());
                    existingClient.setIdentifiantProspect(client.getIdentifiantProspect());
                    existingClient.setProfession(client.getProfession());
                    existingClient.setRegion(client.getRegion());
                    existingClient.setVille(client.getVille());
                    clienRepository.save(existingClient);
                    updatedClients.add(existingClient);
                    log.info("ClientRetail mis à jour : " + existingClientSni);
                }
            } else {
                clienRepository.save(client);
                updatedClients.add(client);
                log.info("Nouveau ClientRetail inséré : " + client);
            }
        }
        return updatedClients;
    }




    private static final Logger log = (Logger) LoggerFactory.getLogger(ClientService.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Set<ClientSni> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<ClientCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(ClientCsvRepresentation.class);
            CsvToBean<ClientCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<ClientCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> {
                                try {
                                    ClientSni clientSni = ClientSni.builder()
                                            .codeRelation(csvLine.getCode_relation())
                                            .idNat(csvLine.getIdNat())
                                            .denomination(csvLine.getDenomination())
                                            .adresse(csvLine.getAdr())
                                            .agence(csvLine.getAgence())
                                            .ville(csvLine.getVille())
                                            .region(csvLine.getRegion())
                                            .dateNaissance(simpleDateFormat.parse(csvLine.getDateNais()))
                                            .profession(csvLine.getProf())
                                            .dateDebutRelation(simpleDateFormat.parse(csvLine.getDate_debut_relation()))
                                            .autre(csvLine.getAutre_info())
                                            .codeRelationFlexcube(csvLine.getCode_relation_flexcube())
                                            .identifiantProspect(csvLine.getIdentifiant_prospect())
                                            .build();
                                    log.info(clientSni.toString());
                                    return clientSni;
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                    ).collect(Collectors.toSet());
        }
    }
}
