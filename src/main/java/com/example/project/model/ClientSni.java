package com.example.project.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("sni")
public class ClientSni extends Client {

    @Column (name="rai_soc")
    private  String raiSoc;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_sec",referencedColumnName = "cod_sec")
    private SniSecteur sniSecteur;

    @Builder
    public ClientSni (long codeRelation, String idNat, String denomination ,String codeRelationFlexcube, String identifiantProspect, String profession, String adresse, String agence, String ville, String region, Date dateNaissance, Date dateDebutRelation, String autre){
        super();
        this.raiSoc = getRaiSoc();
        this.sniSecteur = getSniSecteur();
        super.setCodeRelation(codeRelation);
        super.setIdNat(idNat);
        super.setCodeRelationFlexcube(codeRelationFlexcube);
        super.setIdentifiantProspect(identifiantProspect);
        super.setProfession(profession);
        super.setAdresse(adresse);
        super.setAgence(agence);
        super.setVille(ville);
        super.setDateNaissance(dateNaissance);
        super.setDateDebutRelation(dateDebutRelation);
        super.setAutre(autre);
        super.setDenomination(denomination);
        super.setRegion(region);

    }
}
