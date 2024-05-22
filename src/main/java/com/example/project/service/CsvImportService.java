package com.example.project.service;

import com.example.project.model.Client;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvImportService {

    public List<Client> importClientsFromCsv(String filePath) {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Client client = new Client();
                // Remplir les champs du client à partir des données du fichier CSV

                client.setProfession(data[1]);
                // Ajouter d'autres champs selon votre modèle Client
                clients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
