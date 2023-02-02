package play.genshin.akasha.repository;

import play.genshin.akasha.domain.character.dto.EffectiveRequestDTO;
import play.genshin.akasha.domain.character.dto.PracticeDTO;

import java.util.List;

public interface EffectiveRepositoryCustom {

    List<PracticeDTO> search(EffectiveRequestDTO dto);
}
