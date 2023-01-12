package play.genshin.akasha.domain.sync;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import play.genshin.akasha.globals.common.Globals;
import play.genshin.akasha.globals.initializing.Initializing;

@RestController
@RequiredArgsConstructor
public class SyncAPI {

    private final Initializing initializing;

    @GetMapping("v1/char/sync")
    public ResponseEntity charSync(){
        Globals.characterSpec.clear();
        Globals.effectiveOptions.clear();
        initializing.init();

        return ResponseEntity.ok().build();
    }


}
