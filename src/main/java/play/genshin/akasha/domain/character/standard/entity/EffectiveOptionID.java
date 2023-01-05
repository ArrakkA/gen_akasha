package play.genshin.akasha.domain.character.standard.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
public class EffectiveOptionID implements Serializable {
    private String charName;
    private String partyType;
    private String validMain;
}
