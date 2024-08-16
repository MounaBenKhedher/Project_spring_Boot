package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class  ENUMERATION extends Score {
    private String valeur;

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
