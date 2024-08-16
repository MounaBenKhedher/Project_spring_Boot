package com.example.project.repository;


import com.example.project.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByDisabledFalse();
    @Query("SELECT m FROM Model m WHERE m.disabled = true")
    List<Model> findModelesToBeSoftDisabled();
    @Query("SELECT m FROM Model m WHERE m.disabled = false")
    List<Model> findModelesSoftDisabled();
    List<Model> findByUsed(boolean used);

    Optional<Model> findByUsedTrue();

    List<Model> findByNameAndAnnee(String name, int annee);
}
