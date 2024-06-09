package com.example.project.repository;

import com.example.project.model.Client;
import com.example.project.model.FinancialData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<FinancialData,Long> {
}
