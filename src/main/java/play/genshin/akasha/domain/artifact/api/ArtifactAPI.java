package play.genshin.akasha.domain.artifact.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import play.genshin.akasha.domain.artifact.dto.ArtifactDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactRequestDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactResponseDTO;
import play.genshin.akasha.domain.artifact.service.ArtefactService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
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
                .filter(e -> e.getArtifactPart().equals("flower"))
                .collect(Collectors.toList()));

        responseDTO.getFeathers().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("feather"))
                .collect(Collectors.toList()));

        responseDTO.getHourglasses().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("hourglass"))
                .collect(Collectors.toList()));

        responseDTO.getHolyGrails().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("holyGrail"))
                .collect(Collectors.toList()));

        responseDTO.getHats().addAll(effectiveArtifact.stream()
                .filter(e -> e.getArtifactPart().equals("hat"))
                .collect(Collectors.toList()));

        return ResponseEntity.ok().body(responseDTO);
    }





}
