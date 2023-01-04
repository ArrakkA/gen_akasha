package play.genshin.akasha.domain.artifact.dto;

import lombok.Data;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.standard.entity.EffectiveOption;

@Data
public class ArtifactDTO {
    private int artifactCd;
    private String artifactPart;
    private int artifactNo;
    private String mainOption;
    private double attack;
    private double attackPer;
    private double defense;
    private double defensePer;
    private double healthPoint;
    private double healthPointPer;
    private double elementMastery;
    private double elementCharge;
    private double criticalProbability;
    private double criticalDamage;
    private double artifactScore;

    public ArtifactDTO(Artifact artifact, EffectiveOption effectiveOption) {
        this.artifactCd = artifact.getArtifactCd();
        this.artifactPart = artifact.getArtifactPart();
        this.artifactNo = artifact.getArtifactNo();
        this.mainOption = artifact.getMainOption();
        this.attack = (effectiveOption.getAttackYn().equals("1")) ? artifact.getAttack() : 0;
        this.attackPer =  (effectiveOption.getAttackPerYn().equals("1")) ? artifact.getAttackPer() : 0;
        this.defense =  (effectiveOption.getDefenseYn().equals("1")) ? artifact.getDefense() : 0;
        this.defensePer =  (effectiveOption.getDefensePerYn().equals("1")) ? artifact.getDefensePer() : 0;
        this.healthPoint = (effectiveOption.getHealthPointYn().equals("1")) ? artifact.getHealthPoint() : 0;
        this.healthPointPer =(effectiveOption.getHealthPointPerYn().equals("1")) ? artifact.getHealthPointPer() : 0;
        this.elementMastery = (effectiveOption.getElementMasteryYn().equals("1")) ? artifact.getElementMastery() : 0;
        this.elementCharge = (effectiveOption.getElementChargeYn().equals("1")) ? artifact.getElementCharge() : 0;
        this.criticalProbability = (effectiveOption.getCriticalProbabilityYn().equals("1")) ? artifact.getCriticalProbability() : 0;
        this.criticalDamage = (effectiveOption.getCriticalDamageYn().equals("1")) ? artifact.getCriticalDamage() : 0;

        this.artifactScore = (attack/800) + (attackPer/5.8) + (defense/700) +(defensePer/7.3)
                + (healthPointPer/5.8) + (healthPoint/12000) + (elementMastery/24)
                + (elementCharge/6.5) + (criticalProbability/3.9) + (criticalDamage/7.8);
    }
}
