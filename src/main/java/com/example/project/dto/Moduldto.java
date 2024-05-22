package com.example.project.dto;

import com.example.project.form.ModulForm;
import com.example.project.model.Modul;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class Moduldto extends ModulForm {

    @JsonProperty("cdModul")
    private String cdModul;

    @JsonProperty("lbModul")
    private String lbModul;

    public static Moduldto of(Modul modul){
        return new Moduldto(modul);
    }

    public Moduldto(Modul modul) {
        this.cdModul = modul.getCodmodule();
        this.lbModul = modul.getLibmodule();
    }

    public static List<Moduldto> of(List<Modul> moduls){
        return moduls.stream().map(Moduldto::of).collect(Collectors.toList());
    }
}
