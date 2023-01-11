package play.genshin.akasha.domain.artifact.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
public class ArtifactRequestDTO {
    @NotNull
    private String userName;
    @NotNull
    private int artifactCd;
    @NotNull
    private String artifactPart;
    @NotNull
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
