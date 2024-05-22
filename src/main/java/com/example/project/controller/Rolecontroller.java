package com.example.project.controller;

import com.example.project.dto.RoleDto;
import com.example.project.exception.MissingEntity;
import com.example.project.form.RoleForm;
import com.example.project.model.Role;
import com.example.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/roles")
@CrossOrigin(origins = "*")
public class Rolecontroller {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDto> getAllRoles() {
        List<Role> role = roleService.getAllNtRole();
        return RoleDto.of(role);
    }

    @GetMapping("getRoleById/{id}")
    public RoleDto getRoleById(@PathVariable long id) {

            Role role = roleService.getRoleById(id);
            return RoleDto.of(role);
    }

    @PostMapping
    public void saveRole(@RequestBody Role role) {
        roleService.saveNtRole(role);
    }

    @GetMapping("/page")
    public Page<Role> getRolesPaginated(@RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam String sortField, @RequestParam String sortDirection) {
        return roleService.findPaginatedNtRole(pageNo, pageSize, sortField, sortDirection);
    }
    @PutMapping("/updateRole/{id}")
    public RoleDto updateRole(@PathVariable Long id, @RequestBody RoleForm form) throws MissingEntity {
        Role role = roleService.updateRole(id,form);
        return RoleDto.of(role);
    }
    @DeleteMapping("/deleteRole/{id}")
    public Map<String,Boolean> deleteRole(@PathVariable Long id) throws MissingEntity{
        return roleService.deleteRole(id);
    }

    @PostMapping("/addRole")
    public RoleDto addRole(@RequestBody RoleForm form) throws MissingEntity {
        Role role =roleService.addRole(form);
        return RoleDto.of(role);
    }
}
