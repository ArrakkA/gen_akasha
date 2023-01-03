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
    private double mainValue;
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

    public ArtifactDTO(Artifact artifact, EffectiveOption effectiveOption) {
        this.artifactCd = artifact.getArtifactCd();
        this.artifactPart = artifact.getArtifactPart();
        this.artifactNo = artifact.getArtifactNo();
        this.mainOption = artifact.getMainOption();
        this.mainValue = artifact.getArtifactCd();
        this.attack = (effectiveOption.getAttackYn().equals("1")) ? artifact.getAttack() : 0;
        this.attackPer =  (effectiveOption.getAttackPerYn().equals("1")) ? artifact.getAttackPer() : 0;
        this.defense =  (effectiveOption.getDefenseYn().equals("1")) ? artifact.getDefense() : 0;
        this.defensePer =  (effectiveOption.getDefensePerYn().equals("1")) ? artifact.getDefensePer() : 0;
        this.healthPoint = (effectiveOption.getHealthPointYn().equals("1")) ? artifact.getHealthPoint() : 0;
        this.healthPointPer =(effectiveOption.getHealthPointPerYn().equals("1")) ? artifact.getHealthPointPer() : 0;
        this.elementMastery = (effectiveOption.getDefensePerYn().equals("1")) ? artifact.getDefensePer() : 0;
        this.elementCharge = elementCharge;
        this.criticalProbability = criticalProbability;
        this.criticalDamage = criticalDamage;
    }
}
