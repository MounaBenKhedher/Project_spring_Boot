package com.example.project.model;

import com.example.project.dto.Variabledto;
import lombok.*;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;
/*
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="notation")
public class Notation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "client_notation",
            joinColumns = @JoinColumn(name = "notation_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients;
    private String description;

    @Enumerated(EnumType.STRING)
    private ScoreType scoreType;

    private Object scoreValue; // Peut être Double, String, Date, etc.

    public enum ScoreType {
        NUMBER,
        ENUMERATION,
        INTERVALE,
        DATE
    }

    // Méthode pour comparer les types de score
    public boolean isScoreTypeCompatible(Variabledto variable) {
        switch (scoreType) {
            case NUMBER:
                return variable.getType() == Type.NUMBER;
            case ENUMERATION:
                return variable.getType() == Type.ENUMERATION;
            case INTERVALE:
                return variable.getType() == Type.INTERVALE;
            case DATE:
                return variable.getType() == Type.DATE;
            default:
                return false;
        }
    }

    // Getters and setters
}
*/