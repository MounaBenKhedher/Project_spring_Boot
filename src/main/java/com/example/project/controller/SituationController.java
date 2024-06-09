package com.example.project.controller;

import com.example.project.dto.SituationDto;
import com.example.project.exception.MissingEntity;
import com.example.project.model.SituationClientSni;
import com.example.project.repository.FinanceRepository;
import com.example.project.repository.SituationRepository;
import com.example.project.service.SituationClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class SituationController {
    @Autowired
    private SituationClientService situationClientService;
    @Autowired
    private SituationRepository repository;

    @Autowired
    private FinanceRepository financeRepository;

    @GetMapping("/allsit")
    List<SituationDto> getAll(){
        List<SituationClientSni> situationClientSnis =situationClientService.getAllSituation();
        return SituationDto.of(situationClientSnis);
    }


    @GetMapping(value = "/situation/{id}")
    public SituationDto getById(@PathVariable long id) throws MissingEntity {
        SituationClientSni situationClientSni = situationClientService.findById(id);
        return SituationDto.of(situationClientSni);
    }
    @PostMapping(value = "/uploadSituation", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadSituations(
            @RequestPart("file") MultipartFile file) throws IOException {

        Set<SituationClientSni> situations = situationClientService.uploadSituations(file);

        situations.forEach(situationClientSni -> repository.save(situationClientSni));

        return ResponseEntity.ok(situations.size());
    }



    @GetMapping(value = "/situation/search")
    public List<SituationDto> getsituationByclientId(@RequestParam(name = "clientId") long clientId)  {
        List<SituationClientSni> situations = situationClientService.findByClientId(clientId);
        return SituationDto.of(situations);
    }

}

    // Endpoint pour récupérer tous les clients
