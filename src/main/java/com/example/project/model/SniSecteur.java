package com.example.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SniSecteur {
    @Id
    private Long id;
    private String libelle;

    @Column(name = "cod_sec")
    private String codeSecteur;

    // Constructeurs, getters et setters

    public SniSecteur() {
    }

    public SniSecteur(Long id, String libelle, String codeSecteur) {
        this.id = id;
        this.libelle = libelle;
        this.codeSecteur = codeSecteur;
    }}