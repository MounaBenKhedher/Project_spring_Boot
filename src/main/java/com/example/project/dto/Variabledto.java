package com.example.project.dto;

import com.example.project.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Variabledto {
    private long id;
    private String code;
    private String description;
    private Double coefficient;
    private Type type;
    private Long modelId;
    private List<Scoredto> scores;

    public static Variabledto of(Variable variable) {
        Variabledto dto = new Variabledto();
        dto.setId(variable.getId());
        dto.setCode(variable.getCode());
        dto.setDescription(variable.getDescription());
        dto.setCoefficient(variable.getCoefficient());
        dto.setType(variable.getType());

        dto.setScores(variable.getScores().stream()
                .map(score -> {
                    Scoredto scoreDto = new Scoredto();
                    scoreDto.setId(score.getId());
                    scoreDto.setScore(score.getScore());
                    // Removed setValeur, use appropriate mapping based on Score type
                    if (score instanceof NUMBER) {
                        scoreDto.setType("NUMBER");
                        scoreDto.setNum(((NUMBER) score).getValeur());
                    } else if (score instanceof ENUMERATION) {
                        scoreDto.setType("ENUMERATION");
                        scoreDto.setEnumeration(((ENUMERATION) score).getValeur());
                    } else if (score instanceof INTERVALE) {
                        scoreDto.setType("INTERVALE");
                        scoreDto.setVmin(((INTERVALE) score).getvMin());
                        scoreDto.setVmax(((INTERVALE) score).getvMax());
                    } else if (score instanceof DATE) {
                        scoreDto.setType("DATE");
                        scoreDto.setDate(((DATE) score).getValeur());
                    }
                    return scoreDto;
                })
                .collect(Collectors.toList()));

        return dto;
    }
}