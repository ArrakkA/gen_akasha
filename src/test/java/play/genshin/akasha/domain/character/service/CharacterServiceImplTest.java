package play.genshin.akasha.domain.character.service;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.character.dto.PracticeDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static play.genshin.akasha.domain.character.entity.QEffectiveOption.effectiveOption;


@SpringBootTest
@Transactional
class CharacterServiceImplTest {

    @PersistenceContext
    EntityManager em;
    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before(){
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    public void re(){
        String artifactPart = "왕관";
        String mainOption = "원마";
        boolean attack =  true;
        boolean defense = false;
        boolean healthPoint = false;
        boolean elementMastery = false;
        boolean elementCharge = true;
        boolean critical = false;

        List<PracticeDTO> practiceDTOS = searchOption(artifactPart, mainOption, attack, defense, healthPoint, elementMastery, elementCharge, critical);

        for (PracticeDTO practiceDTO : practiceDTOS) {
            System.out.println("practiceDTO = " + practiceDTO);
        }
    }

    private List<PracticeDTO> searchOption(String artifactPart, String mainOption, boolean attack, boolean defense, boolean healthPoint, boolean elementMastery, boolean elementCharge, boolean critical){
        return queryFactory
                .select(Projections.bean(PracticeDTO.class,
                        effectiveOption.charName,
                        effectiveOption.partyType))
                .from(effectiveOption)
                .where(artifactPartEq(artifactPart), mainOptionEq(mainOption), attackEq(attack), defenseEq(defense), healthPointEq(healthPoint), elementMasteryEq(elementMastery), elementChargeEq(elementCharge), criticalEq(critical))
                .fetch();
    }

    private BooleanExpression artifactPartEq(String artifactPart){
        return (artifactPart != null) ? effectiveOption.artifactPart.eq(artifactPart) : null;
    }

    private BooleanExpression mainOptionEq(String validMain){
        return (validMain != null) ? effectiveOption.validMain.eq(validMain) : null;
    }


    private BooleanExpression attackEq(boolean attack){
        return  (attack) ? effectiveOption.attackYn.eq("Y").or(effectiveOption.attackYn.eq("M")) : null;
    }
    private BooleanExpression defenseEq(boolean defense){
        return  (defense) ? effectiveOption.defenseYn.eq("Y").or(effectiveOption.defenseYn.eq("M")) : null;
    }
    private BooleanExpression healthPointEq(boolean healthPoint){
        return  (healthPoint) ? effectiveOption.healthPointYn.eq("Y").or(effectiveOption.healthPointYn.eq("M")) : null;
    }
    private BooleanExpression elementMasteryEq(boolean elementMastery){
        return  (elementMastery) ? effectiveOption.elementMasteryYn.eq("Y").or(effectiveOption.elementMasteryYn.eq("M")) : null;
    }
    private BooleanExpression elementChargeEq(boolean elementCharge){
        return  (elementCharge) ? effectiveOption.elementChargeYn.eq("Y").or(effectiveOption.elementChargeYn.eq("M")) : null;
    }
    private BooleanExpression criticalEq(boolean critical){
        return  (critical) ? effectiveOption.criticalDamageYn.eq("Y").or(effectiveOption.criticalDamageYn.eq("M")) : null;
    }

    private BooleanExpression effectiveOption(boolean attack, boolean defense, boolean healthPoint, boolean elementMastery, boolean elementCharge, boolean critical){
        return attackEq(attack).and(defenseEq(defense)).and(healthPointEq(healthPoint)).and(elementMasteryEq(elementMastery)).and(elementChargeEq(elementCharge)).and(criticalEq(critical));
    }


}