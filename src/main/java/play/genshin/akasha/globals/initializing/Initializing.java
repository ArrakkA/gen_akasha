package play.genshin.akasha.globals.initializing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import play.genshin.akasha.repository.EffectiveOptionRepository;
import play.genshin.akasha.repository.LowestCharRepository;
import play.genshin.akasha.globals.common.Globals;

import javax.annotation.PostConstruct;

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

