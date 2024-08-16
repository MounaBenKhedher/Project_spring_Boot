package com.example.project.repository;

import com.example.project.model.ENUMERATION;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SVEnumRepository extends JpaRepository<ENUMERATION, Long> {
}
