package com.example.project.form;

import com.example.project.model.ERole;
import com.example.project.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoleForm {
    private long id;
    private String cdRole;
    private ERole lbRole;
    public RoleForm() {
    }
    public RoleForm (Role role){
        this.id= role.getId();
        this.cdRole=role.getCodrole();
        this.lbRole=role.getName();
    }
}
