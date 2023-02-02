package play.genshin.akasha.domain.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import play.genshin.akasha.domain.character.entity.LowestCharacter;
import play.genshin.akasha.globals.common.Globals;
import play.genshin.akasha.globals.dto.SpecDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


@Controller
public class PageController {

    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    @GetMapping(value = "/new_artifact")
    public String newArtifact(){
        return "newArtifact";
    }

    @GetMapping(value = "/artifact_list")
    public String artifactList(Model model){

        List<SpecDTO> collect = Globals.characterSpec.stream()
                .collect(groupingBy(c -> new SpecDTO(c.getCharName()),
                        mapping(c -> new SpecDTO.Setting(c.getPartyType(), c.getWeapon()), toList())))
                .entrySet().stream()
                .map(e -> new SpecDTO(e.getKey().getCharName(), e.getValue()))
                .collect(toList());

        collect.forEach(s -> s.getSettings().stream()
                .collect(groupingBy(setting -> new SpecDTO.Setting(setting.getPartyType()),
                        mapping(SpecDTO.Setting::getWeapon, toList())))
                .entrySet().stream()
                .map(e -> new SpecDTO.Setting(e.getKey().getPartyType(), e.getValue().toString())).collect(toList())
        );


        model.addAttribute("char", Globals.characterSpec);
        return "artifactList";
    }

    @GetMapping(value = "/artifact_find")
    public String artifactFind(){
        return "artifactFind";
    }

}
