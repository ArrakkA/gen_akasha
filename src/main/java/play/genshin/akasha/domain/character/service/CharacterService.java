package play.genshin.akasha.domain.character.service;


import play.genshin.akasha.domain.character.dto.registry.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.dto.EffectiveResponseDTO;
import play.genshin.akasha.globals.dto.SpecDTO;

import java.util.List;

public interface CharacterService {

    void standardSave(CharStandardRequestDTO dto);

    List<EffectiveResponseDTO> charPartyName();




}
