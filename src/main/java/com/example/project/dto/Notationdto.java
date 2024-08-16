package com.example.project.dto;

import com.example.project.model.*;
import lombok.*;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notationdto {
    private Long id;
    private String description;
    private String scoreType;  // String pour stocker le type de score
    private Double numberValue;  // Pour NUMBER
    private String enumerationValue;  // Pour ENUMERATION
    private String intervalMin;  // Pour INTERVALE
    private String intervalMax;  // Pour INTERVALE
    private Date dateValue;  // Pour DATE

    public static Notationdto of(Notation notation) {
        Notationdto dto = new Notationdto();
        dto.setId(notation.getId());
        dto.setDescription(notation.getDescription());

        // Mapping des différents types de score aux champs correspondants
        if (notation.getScoreValue() instanceof NUMBER) {
            dto.setScoreType(Notation.ScoreType.valueOf("NUMBER"));
            dto.setNumberValue(((NUMBER) notation.getScoreValue()).getValeur());
        } else if (notation.getScoreValue() instanceof ENUMERATION) {
            dto.setScoreType(Notation.ScoreType.valueOf("ENUMERATION"));
            dto.setEnumerationValue(((ENUMERATION) notation.getScoreValue()).getValeur());
        } else if (notation.getScoreValue() instanceof INTERVALE) {
            dto.setScoreType(Notation.ScoreType.valueOf("INTERVALE"));
            dto.setIntervalMin(((INTERVALE) notation.getScoreValue()).getvMin());
            dto.setIntervalMax(((INTERVALE) notation.getScoreValue()).getvMax());
        } else if (notation.getScoreValue() instanceof DATE) {
            dto.setScoreType(Notation.ScoreType.valueOf("DATE"));
            dto.setDateValue(((DATE) notation.getScoreValue()).getValeur());
        }

        return dto;
    }



    // ...


    private void setScoreType(Notation.ScoreType scoreType) {
    }

    public enum ScoreType {
        NUMBER,
        ENUMERATION,
        INTERVALE,
        DATE
    }
}*/
