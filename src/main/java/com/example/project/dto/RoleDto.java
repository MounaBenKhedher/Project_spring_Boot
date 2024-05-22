package com.example.project.dto;

import com.example.project.form.RoleForm;
import com.example.project.model.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleDto extends RoleForm {
    private Long id;


    public static RoleDto of(Role role){
        return new RoleDto(role);
    }

    public RoleDto(Role role) {
        super(role);
        this.id = role.getId();
    }

    public static List<RoleDto> of(List<Role> roles){
        return roles.stream().map(RoleDto::of).collect(Collectors.toList());
    }
}
