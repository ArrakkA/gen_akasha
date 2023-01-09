package play.genshin.akasha.domain.character.service;


import play.genshin.akasha.domain.character.dto.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.standard.dto.EffectiveDTO;
import play.genshin.akasha.domain.character.standard.dto.EffectiveResponseDTO;

import java.util.List;

public interface CharacterService {

    void standardSave(CharStandardRequestDTO dto);

    List<EffectiveResponseDTO> charPartyName();

}
