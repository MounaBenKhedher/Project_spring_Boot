package com.example.project.dto;

import com.example.project.form.PrivilegeForm;
import com.example.project.model.Menu;
import com.example.project.model.Privilege;
import com.example.project.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class Privilegedto  {
    private long id;
    private String roleId;
    private RoleDto role;
    private String menuId;
    private Menudto menu;

    public Privilegedto(Privilege privilege){
        this.id = privilege.getId();
        this.roleId = privilege.getRole().getName().toString();
        this.role = RoleDto.of(privilege.getRole());
        this.menuId = privilege.getMenu().getCodmenu();
        this.menu=Menudto.of(privilege.getMenu());
    }
}

