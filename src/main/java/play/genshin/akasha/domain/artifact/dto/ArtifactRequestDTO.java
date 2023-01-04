package play.genshin.akasha.domain.artifact.dto;

import lombok.Data;

@Data
public class ArtifactRequestDTO {
    private String userName;
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
}
