package play.genshin.akasha.domain.character.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import play.genshin.akasha.domain.character.dto.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.service.CharacterService;
import play.genshin.akasha.domain.character.standard.dto.EffectiveResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"캐릭터 API"})
public class CharacterAPI {

    private final CharacterService characterService;
    @ApiOperation(value = "캐릭터 유효옵션 등록")
    @PostMapping("v1/character/standard")
    public ResponseEntity standardChar(
            @RequestBody CharStandardRequestDTO dto
            ){
        characterService.standardSave(dto);

        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "존재하는 캐릭터 세팅")
    @GetMapping("v1/character/party")
    public ResponseEntity partyOfChar(){

        List<EffectiveResponseDTO> charPartyName = characterService.charPartyName();

        return ResponseEntity.ok().body(charPartyName);
    }





}
