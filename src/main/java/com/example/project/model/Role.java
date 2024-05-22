package com.example.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column (name="lib_role",length = 25)
    private ERole name;

    @Column (name="cod_role")
    private String codrole;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Privilege> privileges;


}
