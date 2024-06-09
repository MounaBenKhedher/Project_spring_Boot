package com.example.project.controller;

import com.example.project.exception.MissingEntity;
import com.example.project.model.Client;

import com.example.project.repository.ClienRepository;

import com.example.project.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClienRepository clienRepository;
    @PostMapping(value = "/uploadClient", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadClients(
            @RequestPart("file")MultipartFile file) throws IOException {

        Set<Client> clients = clientService.uploadClients(file);

        clients.forEach(client -> clienRepository.save(client));

        return ResponseEntity.ok(clients.size());
    }


    // Endpoint pour récupérer tous les clients
    @GetMapping("/allclient")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clienRepository.findAll();
        return ResponseEntity.ok().body(clients);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long id) {
        try {
            Client client = clientService.findById(id);
            return ResponseEntity.ok().body(client);
        } catch (MissingEntity e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un client par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClientById(@PathVariable("id") long id) {
        try {
            Map<String, Boolean> response = clientService.deleteclient(id);
            return ResponseEntity.ok().body(response);
        } catch (MissingEntity e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("updateClient/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client clientDetails) {
        try {
            Client updatedClient = clientService.updateClient(id, clientDetails);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/clients/search")
    public ResponseEntity<Client> getClientByCodeRelation(@RequestParam long codeRelation) {
        Optional<Client> client = clientService.findClientByCodeRelation(codeRelation);
        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/client/search")
    public ResponseEntity<Client> getClientByCodeRelationAndId(@RequestParam long id) {
        Optional<Client> client = clientService.findClientById( id);
        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}