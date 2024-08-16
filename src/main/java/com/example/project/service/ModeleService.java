package com.example.project.service;

import com.example.project.exception.MissingEntity;
import com.example.project.form.ModeleForm;
import com.example.project.model.Model;

import java.util.List;

public interface ModeleService {
    List<Model> getAllModele();

    public Model addModele(ModeleForm form) throws MissingEntity;
    Model getModeleById(long id) throws MissingEntity;
    public Model updateModele(Long id, ModeleForm form) throws MissingEntity;
    void deleteModele(Long id) throws MissingEntity;
    public List<Model> getModelesToBeSoftDisabled();
    public List<Model> getModelesSoftDisabled();

    public List<Model> getModelesUsed();

    public List<Model> getModelesNotUsed();
    public void restoreModele(Long id) throws MissingEntity;
    public List<Model> searchByNameAndAnnee(String name , int annee);
}
