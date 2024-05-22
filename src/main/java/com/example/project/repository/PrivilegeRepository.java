package com.example.project.repository;

import com.example.project.model.Privilege;
import com.example.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {

    List<Privilege> findByRole(Role role);
    List<Privilege> findByRoleId(long roleId);
}
