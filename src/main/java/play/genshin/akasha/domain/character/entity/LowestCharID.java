package play.genshin.akasha.domain.character.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
public class LowestCharID implements Serializable {
    private String charName;
    private String partyType;
    private String weapon;
}
