package play.genshin.akasha.domain.character.standard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import play.genshin.akasha.domain.character.standard.entity.EffectiveOption;
import play.genshin.akasha.domain.character.standard.entity.EffectiveOptionID;

import java.util.List;

public interface EffectiveOptionRepository extends JpaRepository<EffectiveOption, EffectiveOptionID> {

    List<EffectiveOption> findEffectiveOptionByCharNameAndPartyType(String charName, String partyType);

}
