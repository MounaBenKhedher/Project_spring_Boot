package com.example.project.repository;

import com.example.project.model.Client;
import com.example.project.model.SituationClientSni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SituationRepository extends JpaRepository<SituationClientSni,Long> {
    Optional<Client> findByCodeRelation(long codeRelation);
    List<SituationClientSni> findByClientId(long clientId) ;
}
