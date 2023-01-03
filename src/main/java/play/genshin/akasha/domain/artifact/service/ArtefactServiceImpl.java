package play.genshin.akasha.domain.artifact.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.artifact.repository.ArtifactRepository;
import play.genshin.akasha.domain.standard.entity.EffectiveOption;
import play.genshin.akasha.domain.standard.repository.EffectiveOptionRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ArtefactServiceImpl implements ArtefactService{

    private final ArtifactRepository artifactRepository;
    private final EffectiveOptionRepository effectiveOptionRepository;

    @Override
    public List<Artifact> makeArtefactScore(String charName, String partyType) {
        List<Artifact> all = artifactRepository.findAll();
        List<EffectiveOption> effective = effectiveOptionRepository.findEffectiveOptionByCharNameAndPartyType(charName, partyType);


        return null;
    }
}
