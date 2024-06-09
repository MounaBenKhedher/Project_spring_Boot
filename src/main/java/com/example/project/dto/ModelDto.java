package com.example.project.dto;

import com.example.project.form.ModeleForm;
import com.example.project.model.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ModelDto extends ModeleForm {
    public ModelDto(Model modele) {
        super(modele);
    }

    public static ModelDto of(Model modele){
        return new ModelDto(modele);
    }

    public static List<ModelDto> of(List<Model> modeles){
        return modeles.stream().map(ModelDto::of).collect(Collectors.toList());
    }
}