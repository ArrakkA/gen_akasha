package play.genshin.akasha.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import play.genshin.akasha.domain.character.dto.EffectiveRequestDTO;
import play.genshin.akasha.domain.character.dto.PracticeDTO;
import play.genshin.akasha.domain.character.dto.QPracticeDTO;

import javax.persistence.EntityManager;
import java.util.List;

import static play.genshin.akasha.domain.character.entity.QEffectiveOption.effectiveOption;

public class EffectiveOptionRepositoryImpl implements EffectiveRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    public EffectiveOptionRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PracticeDTO> search(EffectiveRequestDTO dto) {
        return searchOption(dto);
    }

    private List<PracticeDTO> searchOption(EffectiveRequestDTO dto){
        return queryFactory
                .select(new QPracticeDTO(
                        effectiveOption.charName,
                        effectiveOption.partyType))
                .from(effectiveOption)
                .where(artifactPartEq(dto.getArtifactPart()), mainOptionEq(dto.getMainOption())
                        , attackEq(dto.isAttack()), defenseEq(dto.isDefense())
                        , healthPointEq(dto.isHealthPoint()), elementMasteryEq(dto.isElementMastery())
                        , elementChargeEq(dto.isElementCharge()), criticalEq(dto.isCritical()))
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
}
