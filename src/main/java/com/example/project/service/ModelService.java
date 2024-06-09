package com.example.project.service;

import com.example.project.model.Model;
import com.example.project.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    public Model save(Model model) {
        return modelRepository.save(model);
    }

    public Model update(Long id, Model updatedModel) {
        return modelRepository.findById(id).map(model -> {
            model.setName(updatedModel.getName());
            model.setDescription(updatedModel.getDescription());
            model.setDateCreation(updatedModel.getDateCreation());
            model.setDateUpdate(updatedModel.getDateUpdate());
            model.setUsed(updatedModel.isUsed());
            model.setUpdatebale(true);

            model.setNextUpdateDate(new Date());
            model.setLastUsedDate(updatedModel.getLastUsedDate());
            model.setDisabled(updatedModel.isDisabled());
            model.setMinCaValue(updatedModel.getMinCaValue());
            model.setMaxCaValue(updatedModel.getMaxCaValue());
            model.setWithFinancialData(updatedModel.isWithFinancialData());
            return modelRepository.save(model);
        }).orElseGet(() -> {
            updatedModel.setId(id);
            return modelRepository.save(updatedModel);
        });
    }

    public void deleteById(Long id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Model not found"));
        model.setDisabled(true);
        modelRepository.save(model);
    }
    public void restoreById(Long id) {
        Model model = modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Model not found"));
        model.setDisabled(false);
        modelRepository.save(model);
    }
}