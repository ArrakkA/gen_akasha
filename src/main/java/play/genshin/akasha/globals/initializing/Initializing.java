package play.genshin.akasha.globals.initializing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import play.genshin.akasha.repository.EffectiveOptionRepository;
import play.genshin.akasha.repository.LowestCharRepository;
import play.genshin.akasha.globals.common.Globals;

import javax.annotation.PostConstruct;
import java.util.Arrays;
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


        List<String> artifactName = Arrays.asList("검투", "악단", "왕실", "기사도", "소녀", "청록", "반암", "유성", "뇌명", "번분", "현인", "마녀",
                "얼음", "몰락", "천암", "창백", "시메", "절연", "껍데기", "조개", "진사", "제사", "숲기", "도금", "누각", "낙원");
        int i = 0;
        for (String s : artifactName) {
            i++;
            Globals.artifactCdName.put(String.valueOf(i), s);
        }
    }

}

