package play.genshin.akasha.domain.character.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import play.genshin.akasha.domain.character.dto.EffectiveRequestDTO;
import play.genshin.akasha.domain.character.dto.PracticeDTO;
import play.genshin.akasha.domain.character.dto.registry.CharStandardRequestDTO;
import play.genshin.akasha.domain.character.service.CharacterService;
import play.genshin.akasha.domain.character.dto.EffectiveResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"캐릭터 API"})
public class CharacterAPI {

    private final CharacterService characterService;
    @ApiOperation(value = "캐릭터 유효옵션 등록")
    @PostMapping("v1/character/effective")
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

    @ApiOperation(value = "성유물 누가씀?")
    @GetMapping("v1/character/use")
    public ResponseEntity whoUseThis(
            @ApiParam(value = "성유물 파트")
            @RequestParam(value = "artifactPart")String artifactPart,
            @ApiParam(value = "주 옵션")
            @RequestParam(value = "mainOption")String mainOption,
            @ApiParam(value = "공격력 유효")
            @RequestParam(value = "attack")boolean attack,
            @ApiParam(value = "방어력 유효")
            @RequestParam(value = "defense")boolean defense,
            @ApiParam(value = "체력 유효")
            @RequestParam(value = "healthPoint")boolean healthPoint,
            @ApiParam(value = "원마 유효")
            @RequestParam(value = "elementMastery")boolean elementMastery,
            @ApiParam(value = "원충 유효")
            @RequestParam(value = "elementCharge")boolean elementCharge,
            @ApiParam(value = "크리 유효")
            @RequestParam(value = "critical")boolean critical
            ){

        EffectiveRequestDTO dto = EffectiveRequestDTO.builder()
                .artifactPart(artifactPart)
                .mainOption(mainOption)
                .attack(attack)
                .defense(defense)
                .healthPoint(healthPoint)
                .elementMastery(elementMastery)
                .elementCharge(elementCharge)
                .critical(critical)
                .build();

        List<PracticeDTO> practiceDTOS = characterService.whoUseThis(dto);

        return  ResponseEntity.ok().body(practiceDTOS);
    }


}
