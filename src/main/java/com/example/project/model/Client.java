package com.example.project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name="code_relation")
    private long codeRelation;
    @Column (name="id_nat")
    private String idNat;
    private String codeRelationFlexcube;
    private String identifiantProspect;
    private String denomination ;
    private  String profession;
    private String adresse;
    private String agence;
    private String ville;
    private String region;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebutRelation;
    @Column(name="autre_information",columnDefinition="BLOB")
    @Lob
    private String autre;





}
