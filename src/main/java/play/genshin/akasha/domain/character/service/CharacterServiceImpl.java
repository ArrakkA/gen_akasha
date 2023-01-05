package play.genshin.akasha.domain.character.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.character.dto.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.standard.entity.EffectiveOption;
import play.genshin.akasha.domain.character.standard.repository.EffectiveOptionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService{

    private final EffectiveOptionRepository effectiveOptionRepository;


    @Override
    public void standardSave(CharStandardRequestDTO dto) {
        EffectiveOption save = new EffectiveOption(dto);
        effectiveOptionRepository.save(save);

    }
}
