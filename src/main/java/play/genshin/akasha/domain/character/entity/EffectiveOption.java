package play.genshin.akasha.domain.character.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import play.genshin.akasha.domain.character.dto.registry.CharStandardRequestDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "effective_option")
@IdClass(EffectiveOptionID.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EffectiveOption {
    @Id
    private String charName;
    @Id
    private String partyType;
    @Id
    private String validMain;
    private String artifactPart;

    private String attackYn;
    private String defenseYn;
    private String healthPointYn;
    private String elementMasteryYn;
    private String elementChargeYn;
    private String criticalDamageYn;

    public EffectiveOption(CharStandardRequestDTO dto) {
        this.charName = dto.getCharName();
        this.partyType = dto.getPartyType();
        this.validMain = dto.getValidMain();
        this.artifactPart = dto.getArtifactPart();
        this.attackYn = dto.getAttack();
        this.defenseYn = dto.getDefense();
        this.healthPointYn = dto.getHealthPoint();
        this.elementMasteryYn = dto.getElementMastery();
        this.elementChargeYn = dto.getElementCharge();
        this.criticalDamageYn = dto.getCriticalDamage();
    }
}
