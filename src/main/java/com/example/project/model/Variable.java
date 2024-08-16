package com.example.project.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Variable",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "code")
        }
)
@JsonIgnoreProperties({"modele", "scores"})
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String description;
    private Double coefficient;
    @Enumerated(EnumType.STRING)
    private Type type;
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "modele_id",referencedColumnName = "id")
    private Model modele;

    @OneToMany(mappedBy = "variable", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Score> scores;
}