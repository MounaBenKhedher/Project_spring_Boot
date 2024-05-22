package com.example.project.dto;

import com.example.project.form.MenuForm;
import com.example.project.model.Menu;
import com.example.project.model.Modul;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@NoArgsConstructor
public class Menudto{
    @JsonProperty("codMenu")
    private String codMenu;

    @JsonProperty("libMenu")
    private String libMenu;


    private String codmodule ;
    private Moduldto module ;

    public static Menudto of(Menu menu){

        return new Menudto(menu);
    }

    public Menudto(Menu menu) {
        this.codMenu=menu.getCodmenu();
        this.libMenu=menu.getLibmenu();
        this.codmodule=menu.getModule().getCodmodule();
        this.module=Moduldto.of(menu.getModule());

    }

    public static List<Menudto> of(List<Menu> menus){
        return menus.stream().map(Menudto::of).collect(Collectors.toList());
    }
}
