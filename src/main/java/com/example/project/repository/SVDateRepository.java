package com.example.project.repository;

import com.example.project.model.DATE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SVDateRepository extends JpaRepository<DATE, Long> {
}
