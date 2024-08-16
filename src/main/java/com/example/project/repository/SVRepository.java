package com.example.project.repository;

import com.example.project.model.Score;
import com.example.project.model.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SVRepository extends JpaRepository<Score, Long> {
    List<Score> findByVariable(Variable variable);
    Optional<Score> findById(Long id);
    List<Score> findByVariable_Id(Long variableId);
}
