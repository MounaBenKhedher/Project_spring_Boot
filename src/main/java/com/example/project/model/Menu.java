package com.example.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="menu")
public class Menu{
    @Id
    @Column(name="cod_menu")
    private String codmenu;


    @Column (name="lib_menu")
    private String libmenu;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "codmod",referencedColumnName = "cod_module")
    private Modul module;
}
/*crud menu/*/