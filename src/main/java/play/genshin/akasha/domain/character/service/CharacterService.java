package play.genshin.akasha.domain.character.service;


import play.genshin.akasha.domain.character.dto.EffectiveRequestDTO;
import play.genshin.akasha.domain.character.dto.EffectiveResponseDTO;
import play.genshin.akasha.domain.character.dto.PracticeDTO;
import play.genshin.akasha.domain.character.dto.registry.CharStandardRequestDTO;

import java.util.List;

public interface CharacterService {

    void standardSave(CharStandardRequestDTO dto);

    List<EffectiveResponseDTO> charPartyName();

    List<PracticeDTO> whoUseThis(EffectiveRequestDTO dto);
}
