package com.example.project.form;


import com.example.project.model.Menu;
import com.example.project.model.Modul;
import com.example.project.model.Privilege;
import com.example.project.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PrivilegeForm {
    private long id ;
    private long roleId;
    private String menuId;
    public PrivilegeForm(Privilege privilege){
        this.id=privilege.getId();

    }

}