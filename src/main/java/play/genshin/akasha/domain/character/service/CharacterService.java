package play.genshin.akasha.domain.character.service;


import play.genshin.akasha.domain.character.dto.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.dto.EffectiveResponseDTO;

import java.util.List;

public interface CharacterService {

    void standardSave(CharStandardRequestDTO dto);

    List<EffectiveResponseDTO> charPartyName();

}
