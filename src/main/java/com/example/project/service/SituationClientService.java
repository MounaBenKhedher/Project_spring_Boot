package com.example.project.service;

import com.example.project.exception.MissingEntity;
import com.example.project.model.ClientSni;
import com.example.project.model.SituationClientSni;
import com.example.project.repository.ClientSniRepository;
import com.example.project.repository.FinanceRepository;
import com.example.project.repository.SituationRepository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SituationClientService {
    @Autowired
    private SituationRepository repository;

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired
    private ClientSniRepository clienRepository;
    public List<SituationClientSni> getAllSituation() {

        return repository.findAll();
    }

    public List<SituationClientSni> findByClientId(long clientId) {
        return repository.findByClientId(clientId);
    }









    public SituationClientSni findById(long id) throws MissingEntity {
        Optional<SituationClientSni> situation= repository.findById(id);
        if(!situation.isPresent()){
            throw new MissingEntity("Menue not found with code Menu : "+id);
        }
        return situation.get();
    }



    private static final Logger log = (Logger) LoggerFactory.getLogger(SituationClientService.class);
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ClientSni getClientById(Long clientId) throws MissingEntity {
        return clienRepository.findById(clientId)
                .orElseThrow(() -> new MissingEntity("Client not found with id: " + clientId));
    }
    public Set<SituationClientSni> uploadSituations(MultipartFile file) throws IOException {
        Set<SituationClientSni> situations = parseCsv(file);
        repository.saveAll(situations);
        return situations;
    }

    private Set<SituationClientSni> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<SituationCsvRepresentation> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(SituationCsvRepresentation.class);
            CsvToBean<SituationCsvRepresentation> csvToBean = new CsvToBeanBuilder<SituationCsvRepresentation>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> {
                        try {
                            Date dateDeSituation = simpleDateFormat.parse(csvLine.getDateDeSituation());
                            Date dateRatingLegacy = simpleDateFormat.parse(csvLine.getDateRatingLegacy());

                            Optional<ClientSni> existingClientOptional = clienRepository.findByCodeRelation(csvLine.getCodeRelation());
                            if (!existingClientOptional.isPresent()) {
                                throw new MissingEntity("Client not found with code relation: " + csvLine.getCodeRelation());
                            }
                            ClientSni existingClient = existingClientOptional.get();

                            return SituationClientSni.builder()
                                    .client(existingClient)
                                    .codeRelation(csvLine.getCodeRelation())
                                    .dateDeSituation(dateDeSituation)
                                    .numeroComptePrincipal(csvLine.getNumeroComptePrincipal())
                                    .consolidationInterne(csvLine.getConsolidationInterne())
                                    .mntEnConsolidation(csvLine.getMntEnConsolidation())
                                    .encoursCT(csvLine.getEncoursCT())
                                    .encoursMT(csvLine.getEncoursMT())
                                    .encoursCreditTresorerie(csvLine.getEncoursCreditTresorerie())
                                    .ratioEngagementCDR(csvLine.getVariationEngagementCDR())
                                    .consolidationAutresBanques(csvLine.getConsolidationAutresBanques())
                                    .besoinAccompagnement(csvLine.getBesoinAccompagnement())
                                    .besoinFinancement(csvLine.getBesoinFinancement())

                                    .trancheEffectif(csvLine.getTrancheEffectif())
                                    .nombreClients(csvLine.getNombreClients())
                                    .etatDuResultat(csvLine.getEtatDuResultat())
                                    .tailleBesoinFutur(csvLine.getTailleBesoinFutur())

                                    .classeBanqueCentrale(csvLine.getClasseBanqueCentrale())
                                    .anneeClassificationCentrale(csvLine.getAnneeClassificationCentrale())
                                    .ratingActuelleLegacy(csvLine.getRatingActuelleLegacy())
                                    .classeRisqueLegacy(csvLine.getClasseRisqueLegacy())
                                    .scoreClientLegacy(csvLine.getScoreClientLegacy())
                                    .dateRatingLegacy(dateRatingLegacy)
                                    .impaye(csvLine.getImpaye())
                                    .montantImpayes(csvLine.getMontantImpayes())
                                    .ratioImpayesEngagements(csvLine.getRatioImpayesEngagements())
                                    .ancienneteImpayes(csvLine.getAncienneteImpayes())

                                    .mouvementsTotauxAnneeN(csvLine.getMouvementsTotauxAnneeN())
                                    .mouvementCreditieurAnneeN1(csvLine.getMouvementsTotauxAnneeN1())
                                    .mouvementCreditieurAnneeN(csvLine.getMouvementCreditieurAnneeN())
                                    .mouvementCreditieurAnneeN1(csvLine.getMouvementCreditieurAnneeN1())
                                    .mouvementDebiteurAnneeN(csvLine.getMouvementDebiteurAnneeN())
                                    .mouvementDebiteurAnneeN1(csvLine.getMouvementDebiteurAnneeN1())
                                    .ratioCreditSoldeMoyen(csvLine.getRatioCreditSoldeMoyen())
                                    .regulariteEcheances(csvLine.getRegulariteEcheances())
                                    .dernierSalaireYTD(csvLine.getDernierSalaireYTD())
                                    .soldeMoyenAnnuelAnneeN(csvLine.getSoldeMoyenAnnuelAnneeN())
                                    .soldeMoyenAnnuelAnneeN1(csvLine.getSoldeMoyenAnnuelAnneeN1())
                                    .totalCreancesGLE(csvLine.getTotalCreancesGLE())
                                    .variationAnnuelleMvtCreditAnneeN(csvLine.getVariationAnnuelleMvtCreditAnneeN())
                                    .variationAnnuelleMvtCreditAnneeN1(csvLine.getVariationAnnuelleMvtCreditAnneeN1())
                                    .variationMvtCredit(csvLine.getVariationMvtCredit())
                                    .rationSoldeMoyenFC(csvLine.getRationSoldeMoyenFC())
                                    .iarCentralDesRisquesCDR(csvLine.getIarCentralDesRisquesCDR())
                                    .variationEngagementCDR(csvLine.getVariationEngagementCDR())
                                    .mntCreditTresorerieCDR(csvLine.getMntCreditTresorerieCDR())
                                    .variationCreditTresoCDR(csvLine.getVariationCreditTresoCDR())
                                    .incident(csvLine.getIncident())
                                    .modeleApplicable(csvLine.getModeleApplicable())
                                    .autresInformation(csvLine.getAutresInformation())
                                    .commentaire(csvLine.getCommentaire())
                                    .variableLibre1(csvLine.getVariableLibre1())
                                    .variableLibre2(csvLine.getVariableLibre2())
                                    .variableLibre3(csvLine.getVariableLibre3())
                                    .variableLibre4(csvLine.getVariableLibre4())
                                    .variableLibre5(csvLine.getVariableLibre5())
                                    .variableLibre6(csvLine.getVariableLibre6())
                                    .variableLibre7(csvLine.getVariableLibre7())
                                    .build();
                        } catch (ParseException e) {
                            log.error("Parsing error for date: {}", csvLine.getDateDeSituation(), e);
                            throw new RuntimeException(e);
                        } catch (MissingEntity e) {
                            throw new RuntimeException(e);
                        }
                    }).collect(Collectors.toSet());
        }
    }

}