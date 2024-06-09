package com.example.project.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Inheritance(strategy = javax.persistence.InheritanceType.TABLE_PER_CLASS)
public class FinancialData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private long codeRelation;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeSituation;
    private String numeroComptePrincipal;
    private String consolidationInterne;
    private double mntEnConsolidation;
    private double encoursCT;
    private double encoursMT;
    private double encoursCreditTresorerie;
    private double ratioEngagementCDR;
    private String consolidationAutresBanques;
    private String besoinAccompagnement;
    private String besoinFinancement;
    private String trancheEffectif;
    private int nombreClients;
    private String etatDuResultat;
    private String tailleBesoinFutur;
    private String classeBanqueCentrale;
    private String anneeClassificationCentrale;
    private String ratingActuelleLegacy;
    private String classeRisqueLegacy;
    private int scoreClientLegacy;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRatingLegacy;
    private String impaye;
    private double montantImpayes;
    private double ratioImpayesEngagements;
    private int ancienneteImpayes;
    private double mouvementsTotauxAnneeN;
    private double mouvementsTotauxAnneeN1;
    private double mouvementCreditieurAnneeN;
    private double mouvementCreditieurAnneeN1;
    private double mouvementDebiteurAnneeN;
    private double mouvementDebiteurAnneeN1;
    private double ratioCreditSoldeMoyen;
    private String regulariteEcheances;
    private double dernierSalaireYTD;
    private double soldeMoyenAnnuelAnneeN;
    private double soldeMoyenAnnuelAnneeN1;
    private double totalCreancesGLE;
    private double variationAnnuelleMvtCreditAnneeN;
    private double variationAnnuelleMvtCreditAnneeN1;
    private double variationMvtCredit;
    private double rationSoldeMoyenFC;
    private String iarCentralDesRisquesCDR;
    private double variationEngagementCDR;
    private double mntCreditTresorerieCDR;
    private double variationCreditTresoCDR;
    private String incident;
    private String modeleApplicable;
    private String autresInformation;
    private String commentaire;
    private String variableLibre1;
    private String variableLibre2;
    private String variableLibre3;
    private String variableLibre4;
    private String variableLibre5;
    private String variableLibre6;
    private String variableLibre7;




}
