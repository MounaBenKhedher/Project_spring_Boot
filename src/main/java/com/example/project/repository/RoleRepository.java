package com.example.project.repository;

import com.example.project.model.ERole;
import com.example.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

    List<Role> findById(Role role);
}
