package com.example.project.service;

import com.example.project.exception.MissingEntity;
import com.example.project.form.RoleForm;
import com.example.project.model.Role;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<Role> getAllNtRole();

    Page<Role> findPaginatedNtRole(int pageNoNtRole, int pageSize, String sortField, String sortDirection);

    void saveNtRole(Role ntRole);

    Role getRoleById(long id);

    public Role updateRole(Long id, RoleForm form) throws MissingEntity;

    public Map<String,Boolean> deleteRole(Long id) throws MissingEntity;

    public Role addRole(RoleForm form) throws MissingEntity;



}
