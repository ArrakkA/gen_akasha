package play.genshin.akasha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import play.genshin.akasha.domain.character.dto.EffectiveDTO;
import play.genshin.akasha.domain.character.entity.EffectiveOption;
import play.genshin.akasha.domain.character.entity.EffectiveOptionID;

import java.util.List;

public interface EffectiveOptionRepository extends JpaRepository<EffectiveOption, EffectiveOptionID>, EffectiveRepositoryCustom {
    @Query("select a.charName as charName, a.partyType as partyType from EffectiveOption a")
    List<EffectiveDTO> findCharOption();

}
