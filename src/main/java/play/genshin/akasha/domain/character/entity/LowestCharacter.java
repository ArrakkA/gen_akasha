package play.genshin.akasha.domain.character.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "lowest_char_option")
@IdClass(LowestCharID.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LowestCharacter {
    @Id
    private String charName;
    @Id
    private String partyType;
    @Id
    private String weapon;

    private int attack;
    private int defense;
    private int healthPoint;
    private int elementMastery;
    private int elementCharge;
    private int criticalProbability;
    private int criticalDamage;
    private int mainDamage;
}
