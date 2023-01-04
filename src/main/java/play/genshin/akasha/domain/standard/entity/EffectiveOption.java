package play.genshin.akasha.domain.standard.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "effective_option")
@IdClass(EffectiveOptionID.class)
@Getter
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

}
