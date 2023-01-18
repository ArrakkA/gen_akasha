package play.genshin.akasha.domain.artifact.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.artifact.dto.ArtifactDTO;
import play.genshin.akasha.domain.artifact.dto.ArtifactRequestDTO;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.artifact.exception.UserNotFoundException;
import play.genshin.akasha.domain.artifact.repository.ArtifactRepository;
import play.genshin.akasha.domain.character.entity.EffectiveOption;
import play.genshin.akasha.repository.EffectiveOptionRepository;
import play.genshin.akasha.domain.user.entity.User;
import play.genshin.akasha.domain.user.repository.UserRepository;
import play.genshin.akasha.globals.common.Globals;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ArtefactServiceImpl implements ArtefactService{

    private final ArtifactRepository artifactRepository;
    private final EffectiveOptionRepository effectiveOptionRepository;
    private final UserRepository userRepository;

    @Override
    public List<ArtifactDTO> makeArtefactScore(String charName, String partyType, String userName) {
        List<Artifact> all = artifactRepository.findArtifactByUserName(userName);

        List<EffectiveOption> effective = Globals.effectiveOptions.stream()
                .filter(effectiveOption -> effectiveOption.getCharName().equals(charName) && effectiveOption.getPartyType().equals(partyType))
                .collect(Collectors.toList());

        return all.stream()
                .filter(artifact -> effective.stream().anyMatch(effectiveOption -> effectiveOption.getArtifactPart().equals(artifact.getArtifactPart()) && effectiveOption.getValidMain().equals(artifact.getMainOption())))
                .map(artifact -> new ArtifactDTO(artifact, effective.get(0)))
                .collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparing(ArtifactDTO::getArtifactScore).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void resisterArtefact(ArtifactRequestDTO dto){

        Optional<User> byId = userRepository.findById(dto.getUserName());
        byId.orElseThrow(UserNotFoundException::new);

        int artifactNo = artifactRepository.findArtifactNo(dto.getUserName());

        Artifact artifact = new Artifact(dto, artifactNo + 1);
        artifactRepository.save(artifact);
    }



}
