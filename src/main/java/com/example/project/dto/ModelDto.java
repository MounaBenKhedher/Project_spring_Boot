package com.example.project.dto;

import com.example.project.form.ModeleForm;
import com.example.project.model.Model;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDto extends ModeleForm {
    private long id;
    private List<Variabledto> variables;
    public static ModelDto of(Model modele) {
        ModelDto dto = new ModelDto();
        dto.setId(modele.getId());
        dto.setName(modele.getName());
        dto.setDescription(modele.getDescription());
        dto.setVariables(modele.getVariables().stream()
                .map(Variabledto::of)
                .collect(Collectors.toList()));
        return dto;
    }
    public ModelDto(Model modele) {
        super(modele);
        this.id = modele.getId();
    }

    public static List<ModelDto> of(List<Model> modeles) {
        return modeles.stream().map(ModelDto::of).collect(Collectors.toList());
    }
}