package play.genshin.akasha.domain.character.service;


import play.genshin.akasha.domain.character.dto.CharStandardRequestDTO;

public interface CharacterService {

    void standardSave(CharStandardRequestDTO dto);
}
