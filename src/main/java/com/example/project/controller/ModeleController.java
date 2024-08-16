package com.example.project.controller;

import com.example.project.dto.ModelDto;
import com.example.project.exception.MissingEntity;
import com.example.project.form.ModeleForm;
import com.example.project.model.Model;
import com.example.project.repository.ModelRepository;
import com.example.project.service.ModeleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class ModeleController {

        @Autowired
        ModeleService modeleService;
        @Autowired
    ModelRepository modelRepository ;

        @PostMapping("/addmodels")
        public ModelDto addModele(@RequestBody ModeleForm form) throws MissingEntity {
            Model modele = modeleService.addModele(form);
            return ModelDto.of(modele);
        }

        @GetMapping("/models")
        List<ModelDto> getAllModeles() {
            List<Model> modele = modeleService.getAllModele();
            return ModelDto.of(modele);
        }

        @GetMapping("/models/{id}")
        public ModelDto getModeleById(@PathVariable Long id) throws MissingEntity {
            Model modele = modeleService.getModeleById(id);
            return ModelDto.of(modele);
        }

        @PutMapping("/modelsput/{id}")
        public ModelDto updateModele(@PathVariable Long id, @RequestBody ModeleForm form) throws MissingEntity {
            Model modele = modeleService.getModeleById(id);

            if (modele == null) {
                throw new MissingEntity("Modèle introuvable avec l'ID : " + id);
            }
            form.setDateCreation(modele.getDateCreation());
            modele.setUpdatebale(true);
            modele = modeleService.updateModele(id, form);

            return ModelDto.of(modele);
        }

        @DeleteMapping("/deletemodels/{id}")
        public ResponseEntity<Void> deleteModele(@PathVariable Long id) {
            try {
                modeleService.deleteModele(id);
                return ResponseEntity.noContent().build();
            } catch (MissingEntity e) {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/ModelsSoftDeleted")
        public List<Model> getModelesToBeSoftDeleted() {
            return modeleService.getModelesToBeSoftDisabled();
        }

        @GetMapping("/ModelsSoftDeletedTrue")
        public List<Model> getModelesSoftDeleted() {
            return modeleService.getModelesSoftDisabled();
        }

        @GetMapping("/ModelUsed")
        public ResponseEntity<List<Model>> getModelUsed() {
            List<Model> modelesUtilises = modeleService.getModelesUsed();
            return new ResponseEntity<>(modelesUtilises, HttpStatus.OK);
        }

        @GetMapping("/ModelNotUsed")
        public ResponseEntity<List<Model>> getModelNotUsed() {
            List<Model> modelesNonUtilises = modeleService.getModelesNotUsed();
            return new ResponseEntity<>(modelesNonUtilises, HttpStatus.OK);
        }

        @PutMapping("/restoreModele/{id}")
        public ResponseEntity<Void> restoreModele(@PathVariable Long id) {
            try {
                modeleService.restoreModele(id);
                return ResponseEntity.noContent().build();
            } catch (MissingEntity e) {
                return ResponseEntity.notFound().build();
            }
        }

    @GetMapping(value = "/searchByNameAndAnnee")
    public List<ModelDto> advancedSearch(@RequestParam(name = "name") String name,
                                          @RequestParam(name = "annee", required = true) int annee) throws MissingEntity {
        List<Model> modeles = modeleService.searchByNameAndAnnee(name, annee);
        return ModelDto.of(modeles);

    }
    @PutMapping("/{id}/ModeleUsed")
    public ResponseEntity<Model> toggleModeleUsed(@PathVariable Long id) {
        Optional<Model> optionalModele = modelRepository.findById(id);
        if (optionalModele.isPresent()) {
            Model modele = optionalModele.get();
            modele.setUsed(!modele.isUsed());
            modele.setLastUsedDate(new Date());
            Model updatedModele = modelRepository.save(modele);
            return ResponseEntity.ok(updatedModele);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }
