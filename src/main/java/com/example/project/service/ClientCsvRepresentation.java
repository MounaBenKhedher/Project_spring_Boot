package com.example.project.service;



import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCsvRepresentation {
    @CsvBindByName(column="code_relation_atlas")
    private long code_relation;
    @CsvBindByName(column = "identifiant_national")
    private String idNat;
    @CsvBindByName(column = "denomination_sociale")
    private String denomination;
    @CsvBindByName(column = "adresse")
    private String adr;
    @CsvBindByName(column = "agence")
    private String agence;
    @CsvBindByName(column = "ville")
    private String ville;
    @CsvBindByName(column = "region")
    private String region;

    @CsvBindByName(column = "date_naissance")
    private String dateNais;
    @CsvBindByName(column = "profession")
    private String prof;

    @CsvBindByName(column = "date_debut_relation")
    private String date_debut_relation;

    @CsvBindByName(column = "autre_information")
    private String autre_info;

    @CsvBindByName(column = "code_relation_flexcube")
    private String code_relation_flexcube;
    @CsvBindByName(column = "identifiant_prospect")
    private String identifiant_prospect;


}
