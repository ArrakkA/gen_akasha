package play.genshin.akasha.domain.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import play.genshin.akasha.domain.character.entity.LowestCharacter;
import play.genshin.akasha.globals.common.Globals;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


@Controller
public class PageController {

    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    @GetMapping(value = "/newArtifact")
    public String newArtifact(){
        return "newArtifact";
    }

    @GetMapping(value = "/artifactList")
    public String artifactList(Model model){

        model.addAttribute("char", Globals.characterSpec);
        return "artifactList";
    }

}
