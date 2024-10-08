package com.example.project.repository;


import com.example.project.model.Modul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Modul,String> {

    Optional<Modul> findByCodmodule(String codmodule);



}
