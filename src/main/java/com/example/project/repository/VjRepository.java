package com.example.project.repository;

import com.example.project.model.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VjRepository extends JpaRepository<Variable, Long> {
    Optional<Variable> findByCode (String code);
    Optional<Variable> findById(Long id);
    void deleteById(Long id);
    @Query("SELECT v FROM Variable v LEFT JOIN FETCH v.scores WHERE v.id = :id")
    Optional<Variable> findByIdWithScores(@Param("id") Long id);
}
