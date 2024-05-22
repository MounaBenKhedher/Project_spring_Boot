package com.example.project.form;

import com.example.project.model.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuForm {
    private String codMenu ;
    private String libMenu;
    private String codmodule;
    public MenuForm(Menu menu){
        this.codMenu=menu.getCodmenu();
        this.libMenu=menu.getLibmenu();

    }
}
