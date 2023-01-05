package play.genshin.akasha.domain.character.api;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import play.genshin.akasha.domain.character.dto.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.service.CharacterService;

@RestController
@RequiredArgsConstructor
@Api("캐릭터 API")
public class CharacterAPI {

    private final CharacterService characterService;

    @PostMapping("v1/character/standard")
    public ResponseEntity standardChar(
            @RequestBody CharStandardRequestDTO dto
            ){
        characterService.standardSave(dto);


        return ResponseEntity.ok().build();
    }




}
