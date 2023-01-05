package play.genshin.akasha.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/artifact/new")
    public String newArtifact(){
        return "newArtifact";
    }

    @GetMapping("/artifact/score")
    public String artifactList(){
        return "artifactList";
    }




}
