package play.genshin.akasha.domain.character.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.character.dto.EffectiveDTO;
import play.genshin.akasha.domain.character.dto.EffectiveRequestDTO;
import play.genshin.akasha.domain.character.dto.EffectiveResponseDTO;
import play.genshin.akasha.domain.character.dto.PracticeDTO;
import play.genshin.akasha.domain.character.dto.registry.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.entity.EffectiveOption;
import play.genshin.akasha.repository.EffectiveOptionRepository;

import java.util.List;

import static java.util.stream.Collectors.*;

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

    @Override
    public List<EffectiveResponseDTO> charPartyName() {

        List<EffectiveDTO> charOption = effectiveOptionRepository.findCharOption();
        return charOption.stream()
                .collect(groupingBy(EffectiveDTO::getCharName,
                        mapping(EffectiveDTO::getPartyType, toList())))
                .entrySet().stream()
                .map(e -> new EffectiveResponseDTO(e.getKey(),e.getValue().stream().distinct().collect(toList())))
                .collect(toList());

    }

    @Override
    public List<PracticeDTO> whoUseThis(EffectiveRequestDTO dto) {
        return effectiveOptionRepository.search(dto);
    }


}
