package play.genshin.akasha.domain.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String artifactList(){
        return "artifactList";
    }

}
