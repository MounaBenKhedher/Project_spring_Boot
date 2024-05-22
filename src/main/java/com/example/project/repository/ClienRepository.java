package com.example.project.repository;

import com.example.project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByCodeRelationAndIdNat(long codeRelation, String idNat);
}
