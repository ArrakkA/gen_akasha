package play.genshin.akasha.domain.artifact.dto;

import lombok.Data;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.character.entity.EffectiveOption;
import play.genshin.akasha.globals.common.Common;

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
    private String artifactScore;

    public ArtifactDTO(Artifact artifact, EffectiveOption effectiveOption) {
        this.artifactCd = artifact.getArtifactCd();
        this.artifactPart = artifact.getArtifactPart();
        this.artifactNo = artifact.getArtifactNo();
        this.mainOption = artifact.getMainOption();
        this.attack = Common.useOption(effectiveOption.getAttackYn(), artifact.getAttack());
        this.attackPer = Common.useOption(effectiveOption.getAttackYn(), artifact.getAttackPer());
        this.defense =  Common.useOption(effectiveOption.getDefenseYn(), artifact.getDefense());
        this.defensePer =  Common.useOption(effectiveOption.getDefenseYn(), artifact.getDefensePer());
        this.healthPoint = Common.useOption(effectiveOption.getHealthPointYn(), artifact.getHealthPoint());
        this.healthPointPer = Common.useOption(effectiveOption.getHealthPointYn(), artifact.getHealthPointPer());
        this.elementMastery = Common.useOption(effectiveOption.getElementMasteryYn(), artifact.getElementMastery());
        this.elementCharge = Common.useOption(effectiveOption.getElementChargeYn(), artifact.getElementCharge());
        this.criticalProbability = Common.useOption(effectiveOption.getCriticalDamageYn(), artifact.getCriticalProbability());
        this.criticalDamage = Common.useOption(effectiveOption.getCriticalDamageYn(), artifact.getCriticalDamage());

        this.artifactScore =String.format("%.3f",(attack/46.4) + (attackPer/5.8) + (defense/51.1) +(defensePer/7.3)
                + (healthPointPer/5.8) + (healthPoint/696) + (elementMastery/23)
                + (elementCharge/6.5) + (criticalProbability/3.9) + (criticalDamage/7.8));

    }






}
