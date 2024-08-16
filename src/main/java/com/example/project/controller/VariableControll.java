package com.example.project.controller;

import com.example.project.dto.Scoredto;
import com.example.project.dto.Variabledto;
import com.example.project.exception.MissingEntity;
import com.example.project.model.Model;
import com.example.project.model.Score;
import com.example.project.model.Variable;
import com.example.project.repository.ModelRepository;
import com.example.project.repository.SVRepository;
import com.example.project.repository.VjRepository;
import com.example.project.service.ScoreService;
import com.example.project.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VariableControll {
    @Autowired
    VariableService variableService;
    @Autowired
    ModelRepository modeleRepository;
    @Autowired
    VjRepository variableRepository;
    @Autowired
    ScoreService calculScoreService;
    @Autowired
    SVRepository scoreVariableRepository;
    @PostMapping("/addVariable/{modelId}")
    public ResponseEntity<Variable> addVariable(@RequestBody Variabledto variableRequest, @PathVariable long modelId) {
        try {
            Model modele = modeleRepository.findById(modelId)
                    .orElseThrow(() -> new EntityNotFoundException("No active Modele found with ID: " + modelId));

            Variable variable = new Variable();
            variable.setCode(variableRequest.getCode());
            variable.setDescription(variableRequest.getDescription());
            variable.setCoefficient(variableRequest.getCoefficient());
            variable.setType(variableRequest.getType());
            variable.setModele(modele);

            Variable createdVariable = variableService.createVariable(variable,modelId);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdVariable);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /* @PostMapping("/addVariable")
  public ResponseEntity<Variable> createVariable(@RequestBody Variable variable) {
      Variable createdVariable = variableService.createVariable(variable);
      return new ResponseEntity<>(createdVariable, HttpStatus.CREATED);
  }*/
    @PostMapping("/{variableId}/scores")
    public ResponseEntity<Score> addScoreToVariable(
            @PathVariable long variableId,
            @RequestBody Score score) {
        try {
            variableService.addScoreToVariable(variableId, score);
            return new ResponseEntity<>(score, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllVariables")
    public ResponseEntity<List<Variabledto>> getAllVariablesWithScores() {
        List<Variable> variables = variableService.getAllVariable();
        /*Modele modele = modeleRepository.findByUsedTrue()
                .orElseThrow(() -> new EntityNotFoundException("No active Modele found"));*/

        List<Variabledto> variableDtos = variables.stream().map(variable -> {
            Variabledto variableDto = new Variabledto();
            variableDto.setId(variable.getId());
            variableDto.setCode(variable.getCode());
            variableDto.setCoefficient(variable.getCoefficient());
            variableDto.setType(variable.getType());
            variableDto.setDescription(variable.getDescription());
            // variableDto.setModelId(modele.getId());

            List<Scoredto> scoreDtos = variable.getScores().stream()
                    .map(score -> {
                        Scoredto scoreDto = new Scoredto();
                        scoreDto.setId(score.getId());
                        scoreDto.setScore(score.getScore());
                        //scoreDto.setValeur(score.getValeur());
                        return scoreDto;
                    }).collect(Collectors.toList());

            variableDto.setScores(scoreDtos);
            return variableDto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(variableDtos);
    }
    @GetMapping("/getVariableScoreById/{id}")
    public ResponseEntity<Variabledto> getVariableWithScores(@PathVariable Long id) throws MissingEntity {
        Variable variable = variableService.findById(id);
        List<Scoredto> scoreDtos = variableService.getScoresByVariableId(id);

        Variabledto variableDto = new Variabledto();
        variableDto.setId(variable.getId());
        variableDto.setCode(variable.getCode());
        variableDto.setDescription(variable.getDescription());
        variableDto.setCoefficient(variable.getCoefficient());
        variableDto.setType(variable.getType());
        variableDto.setModelId(variable.getModele().getId());
        variableDto.setScores(scoreDtos);

        return ResponseEntity.ok(variableDto);
    }
    @PutMapping("/updataVariable/{id}")
    public ResponseEntity<Variable> updateVariable(@PathVariable Long id, @RequestBody Variable updatedVariable) {
        Variable updateVariable = variableService.updateVariable(id, updatedVariable);
        return ResponseEntity.ok(updateVariable);
    }
    @DeleteMapping("/deleteVariable/{id}")
    public ResponseEntity<Void> deleteVariable(@PathVariable Long id) {
        try {
            variableService.deleteVariable(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/ponderation/{id}")
    public double getPonderationForVariable(@PathVariable Long id) {
        return variableService.calculatePonderationForVariable(id);
    }

}

