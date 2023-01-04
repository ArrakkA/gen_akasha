package play.genshin.akasha.domain.artifact.service;

import play.genshin.akasha.domain.artifact.dto.ArtifactDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactRequestDTO;

import java.util.List;

public interface ArtefactService {
    List<ArtifactDTO> makeArtefactScore(String charName, String partyType);

    void resisterArtefact(ArtifactRequestDTO dto);

}
