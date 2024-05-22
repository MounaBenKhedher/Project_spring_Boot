package com.example.project.repository;


import com.example.project.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {


    Optional<Menu> findByCodmenu(String codmenu);


}
