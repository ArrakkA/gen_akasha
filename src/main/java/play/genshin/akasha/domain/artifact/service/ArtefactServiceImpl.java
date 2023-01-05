package play.genshin.akasha.domain.artifact.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.artifact.dto.ArtifactDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactRequestDTO;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.artifact.repository.ArtifactRepository;
import play.genshin.akasha.domain.character.standard.entity.EffectiveOption;
import play.genshin.akasha.domain.character.standard.repository.EffectiveOptionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ArtefactServiceImpl implements ArtefactService{

    private final ArtifactRepository artifactRepository;
    private final EffectiveOptionRepository effectiveOptionRepository;

    @Override
    public List<ArtifactDTO> makeArtefactScore(String charName, String partyType, String userName) {
        List<Artifact> all = artifactRepository.findArtifactByUserName(userName);
        List<EffectiveOption> effective = effectiveOptionRepository.findEffectiveOptionByCharNameAndPartyType(charName, partyType);

        return all.stream()
                .filter(artifact -> effective.stream().anyMatch(effectiveOption -> effectiveOption.getArtifactPart().equals(artifact.getArtifactPart()) && effectiveOption.getValidMain().equals(artifact.getMainOption())))
                .map(artifact -> new ArtifactDTO(artifact, effective.get(0)))
                .collect(Collectors.toList());
    }

    @Override
    public void resisterArtefact(ArtifactRequestDTO dto){
        int artifactNo = artifactRepository.findArtifactNo(dto.getUserName());


        Artifact artifact = new Artifact(dto, artifactNo + 1);
        artifactRepository.save(artifact);
    }



}
