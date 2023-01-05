package play.genshin.akasha.domain.artifact.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import play.genshin.akasha.domain.artifact.dto.ArtifactDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactRequestDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactResponseDTO;
import play.genshin.akasha.domain.artifact.service.ArtefactService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Api(tags = {"성유물 관련 API"})
public class ArtifactAPI {

    private final ArtefactService artefactService;

    @ApiOperation(value = "아티팩트 등록")
    @PostMapping("v1/artifact/register")
    public ResponseEntity artifactRegister(
            @RequestBody ArtifactRequestDTO requestDTO
            ){
        artefactService.resisterArtefact(requestDTO);

        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "아티팩트 리스트 확인")
    @GetMapping("v1/artifact/list")
    public ResponseEntity<ArtifactResponseDTO> artifactList(
            @ApiParam(value = "캐릭터 이름")
            @RequestParam(value = "charName")String charName,
            @ApiParam(value = "파티 타입")
            @RequestParam(value = "partyType")String partyType
    ){
        List<ArtifactDTO> effectiveArtifact = artefactService.makeArtefactScore(charName, partyType);
        ArtifactResponseDTO responseDTO = new ArtifactResponseDTO();

        responseDTO.getFlowers().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("꽃"))
                .collect(Collectors.toList()));

        responseDTO.getFeathers().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("깃털"))
                .collect(Collectors.toList()));

        responseDTO.getHourglasses().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("시계"))
                .collect(Collectors.toList()));

        responseDTO.getHolyGrails().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("성배"))
                .collect(Collectors.toList()));

        responseDTO.getCrowns().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("왕관"))
                .collect(Collectors.toList()));

        return ResponseEntity.ok().body(responseDTO);
    }





}
