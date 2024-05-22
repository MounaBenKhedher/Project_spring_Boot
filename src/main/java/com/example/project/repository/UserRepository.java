package com.example.project.repository;

import com.example.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameAndStatus(String username, Boolean status);
    Optional<User> findByUsername(String username); // authentification
    Optional<User> findByEmail(String email); // authentification
    Boolean existsByUsername(String username); //subscribe
    Boolean existsByEmail(String email); //subscribe

}