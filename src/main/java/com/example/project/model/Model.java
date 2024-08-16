package com.example.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Temporal(TemporalType.DATE)
    private Date dateUpdate;

    private boolean used ;
    private boolean updatebale;

    @Temporal(TemporalType.DATE)
    private Date nextUpdateDate;

    @Temporal(TemporalType.DATE)
    private Date lastUsedDate;

    private boolean disabled =false;

    private double minCaValue;
    private double maxCaValue;

    private boolean withFinancialData;
    private int annee;


    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Variable> variables;

    @PrePersist
    public void prePersist() {
        if (!updatebale) {
            nextUpdateDate = null;
        }
        if (!used) {
            lastUsedDate = null;
        }
        dateCreation = new Date();
        dateUpdate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        if (!updatebale) {
            nextUpdateDate = null;
        }
        if (!used) {
            lastUsedDate = null;
        }
        dateUpdate = new Date();
    }
    // Constructors

   }