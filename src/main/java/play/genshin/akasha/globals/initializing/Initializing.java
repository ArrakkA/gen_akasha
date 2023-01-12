package play.genshin.akasha.globals.initializing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import play.genshin.akasha.domain.character.repository.EffectiveOptionRepository;
import play.genshin.akasha.domain.character.repository.LowestCharRepository;
import play.genshin.akasha.globals.common.Globals;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Initializing {

    private final LowestCharRepository lowestCharRepository;
    private final EffectiveOptionRepository effectiveOptionRepository;


    @PostConstruct
    public void init(){
        Globals.characterSpec.addAll(lowestCharRepository.findAll());
        Globals.effectiveOptions.addAll(effectiveOptionRepository.findAll());

    }

}

