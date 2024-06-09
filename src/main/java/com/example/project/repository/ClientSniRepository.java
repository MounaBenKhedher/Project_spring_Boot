package com.example.project.repository;

import com.example.project.model.ClientSni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientSniRepository extends JpaRepository<ClientSni,Long> {
    Optional<ClientSni> findByCodeRelation(Long codeRelation);

}
