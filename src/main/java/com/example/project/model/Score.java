package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double score;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "variable_id", nullable = false)
    private Variable variable;
    @Transient
    private Long variableId;
    public Object getValeur() {
        return null;
    }


}

