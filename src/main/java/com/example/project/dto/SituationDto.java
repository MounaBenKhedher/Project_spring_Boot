package com.example.project.dto;

import com.example.project.model.ClientSni;
import com.example.project.model.SituationClientSni;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SituationDto {

   private long id ;
    private Long clientId;
    private long codeRelation;

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

    public SituationDto(SituationClientSni situationClientSni) {
        this.id=situationClientSni.getId();
        this.clientId=situationClientSni.getClient().getId();
        this.codeRelation =situationClientSni.getCodeRelation() ;
        this.dateDeSituation = situationClientSni.getDateDeSituation();
        this.numeroComptePrincipal = situationClientSni.getNumeroComptePrincipal();
        this.consolidationInterne = situationClientSni.getConsolidationInterne();
        this.mntEnConsolidation = situationClientSni.getMntEnConsolidation();
        this.encoursCT = situationClientSni.getEncoursCT();
        this.encoursMT = situationClientSni.getEncoursMT();
        this.encoursCreditTresorerie =situationClientSni.getEncoursCreditTresorerie();
        this.ratioEngagementCDR = situationClientSni.getRatioEngagementCDR();
        this.consolidationAutresBanques = situationClientSni.getConsolidationAutresBanques();
        this.besoinAccompagnement = situationClientSni.getBesoinAccompagnement();
        this.besoinFinancement = situationClientSni.getBesoinFinancement();
        this.trancheEffectif =situationClientSni.getTrancheEffectif();
        this.nombreClients = situationClientSni.getNombreClients();
        this.etatDuResultat = situationClientSni.getEtatDuResultat();
        this.tailleBesoinFutur = situationClientSni.getTailleBesoinFutur();
        this.classeBanqueCentrale =situationClientSni.getClasseBanqueCentrale();
        this.anneeClassificationCentrale = situationClientSni.getAnneeClassificationCentrale();
        this.ratingActuelleLegacy = situationClientSni.getRatingActuelleLegacy();
        this.classeRisqueLegacy = situationClientSni.getClasseRisqueLegacy();
        this.scoreClientLegacy = situationClientSni.getScoreClientLegacy();
        this.dateRatingLegacy = situationClientSni.getDateRatingLegacy();
        this.impaye = situationClientSni.getImpaye();
        this.montantImpayes = situationClientSni.getMontantImpayes();
        this.ratioImpayesEngagements = situationClientSni.getRatioImpayesEngagements();
        this.ancienneteImpayes = situationClientSni.getAncienneteImpayes();
        this.mouvementsTotauxAnneeN = situationClientSni.getMouvementsTotauxAnneeN();
        this.mouvementsTotauxAnneeN1 = situationClientSni.getMouvementsTotauxAnneeN1();
        this.mouvementCreditieurAnneeN = situationClientSni.getMouvementCreditieurAnneeN();
        this.mouvementCreditieurAnneeN1 = situationClientSni.getMouvementCreditieurAnneeN1();
        this.mouvementDebiteurAnneeN = situationClientSni.getMouvementDebiteurAnneeN();
        this.mouvementDebiteurAnneeN1 = situationClientSni.getMouvementDebiteurAnneeN1();
        this.ratioCreditSoldeMoyen = situationClientSni.getRatioCreditSoldeMoyen();
        this.regulariteEcheances =situationClientSni.getRegulariteEcheances();
        this.dernierSalaireYTD = situationClientSni.getDernierSalaireYTD();
        this.soldeMoyenAnnuelAnneeN = situationClientSni.getSoldeMoyenAnnuelAnneeN();
        this.soldeMoyenAnnuelAnneeN1 = situationClientSni.getSoldeMoyenAnnuelAnneeN1();
        this.totalCreancesGLE = situationClientSni.getTotalCreancesGLE();
        this.variationAnnuelleMvtCreditAnneeN = situationClientSni.getVariationAnnuelleMvtCreditAnneeN();
        this.variationAnnuelleMvtCreditAnneeN1 = situationClientSni.getVariationAnnuelleMvtCreditAnneeN1();
        this.variationMvtCredit = situationClientSni.getVariationMvtCredit();
        this.rationSoldeMoyenFC = situationClientSni.getRationSoldeMoyenFC();
        this.iarCentralDesRisquesCDR = situationClientSni.getIarCentralDesRisquesCDR();
        this.variationEngagementCDR = situationClientSni.getVariationEngagementCDR();
        this.mntCreditTresorerieCDR = situationClientSni.getMntCreditTresorerieCDR();
        this.variationCreditTresoCDR = situationClientSni.getVariationCreditTresoCDR();
        this.incident = situationClientSni.getIncident();
        this.modeleApplicable = situationClientSni.getModeleApplicable();
        this.autresInformation = situationClientSni.getAutresInformation();
        this.commentaire = situationClientSni.getCommentaire();
        this.variableLibre1 = situationClientSni.getVariableLibre1();
        this.variableLibre2 = situationClientSni.getVariableLibre2();
        this.variableLibre3 = situationClientSni.getVariableLibre3();
        this.variableLibre4 = situationClientSni.getVariableLibre4();
        this.variableLibre5 = situationClientSni.getVariableLibre5();
        this.variableLibre6 = situationClientSni.getVariableLibre6();
        this.variableLibre7 = situationClientSni.getVariableLibre7();
    }
    public static SituationDto of(SituationClientSni situationClientSni){

        return new SituationDto(situationClientSni);
    }
    public static List<SituationDto> of(List<SituationClientSni> situationClientSnis){
        return situationClientSnis.stream().map(SituationDto::of).collect(Collectors.toList());
    }

}
