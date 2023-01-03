package play.genshin.akasha.domain.artifact.service;

import play.genshin.akasha.domain.artifact.entity.Artifact;

import java.util.List;

public interface ArtefactService {
    List<Artifact> makeArtefactScore(String charName, String partyType);

}
