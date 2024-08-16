package com.example.project.repository;

import com.example.project.model.NUMBER;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SVNumberRepository extends JpaRepository<NUMBER, Long> {
}
