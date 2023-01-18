package play.genshin.akasha.domain.character.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EffectiveRequestDTO {
   private String artifactPart;
   private String mainOption;
   private boolean attack;
   private boolean defense;
   private boolean healthPoint;
   private boolean elementMastery;
   private boolean elementCharge;
   private boolean critical;

   @Builder
   public EffectiveRequestDTO(String artifactPart, String mainOption, boolean attack, boolean defense, boolean healthPoint, boolean elementMastery, boolean elementCharge, boolean critical) {
      this.artifactPart = artifactPart;
      this.mainOption = mainOption;
      this.attack = attack;
      this.defense = defense;
      this.healthPoint = healthPoint;
      this.elementMastery = elementMastery;
      this.elementCharge = elementCharge;
      this.critical = critical;
   }
}
