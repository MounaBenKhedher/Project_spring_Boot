package com.example.project.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="hab_privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_role",referencedColumnName = "id")
    private Role role;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_menu",referencedColumnName = "cod_menu")
    private Menu menu;



}
