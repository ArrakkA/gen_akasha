package play.genshin.akasha.domain.character.dto;

import lombok.Data;

@Data
public class EffectiveRequestDTO {
   private String artifactPart;
   private String mainOption;
   private boolean attack;
   private boolean defense;
   private boolean healthPoint;
   private boolean elementMastery;
   private boolean elementCharge;
   private boolean critical;
}
