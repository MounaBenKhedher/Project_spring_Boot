package com.example.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="hab_module")
public class Modul {

    @Id
    @Column(name = "cod_module")
    private String codmodule;


    @Column(name = "lib_module")
    private String libmodule;

    @OneToMany(mappedBy = "module")
    List<Menu> menus;
}
