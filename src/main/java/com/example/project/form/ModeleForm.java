package com.example.project.form;

import com.example.project.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModeleForm {
    private long id;
    private String name;
    private String description;
    private Date dateCreation;
    private Date dateUpdate;
    private boolean used;
    private boolean updatebale;
    private Date nextUpdateDate;
    private Date lastUsedDate;
    private boolean disabled;

    private double minCaValue;
    private double maxCaValue;

    private boolean withFinancialData;
private  int Anne ;


    public ModeleForm(int anne) {

    }

    public ModeleForm(Model modele){
        this.id=modele.getId();
        this.name=modele.getName();
        this.description= modele.getDescription();
        this.dateCreation=modele.getDateCreation();
        this.dateUpdate=modele.getDateUpdate();
        this.used=modele.isUsed();
        this.updatebale= modele.isUpdatebale();
        this.nextUpdateDate=modele.getNextUpdateDate();
        this.lastUsedDate=modele.getLastUsedDate();
        this.disabled= modele.isDisabled();
        this.minCaValue =modele.getMinCaValue();
        this.maxCaValue = modele.getMaxCaValue();
        this.Anne = modele.getAnnee() ;
        this.withFinancialData= modele.isWithFinancialData();


    }
}