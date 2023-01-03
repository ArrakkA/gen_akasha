package play.genshin.akasha.domain.artifact.dto;

import lombok.Data;
import play.genshin.akasha.domain.artifact.entity.Artifact;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArtifactResponseDTO {
    private List<Artifact> flowers = new ArrayList<>();
    private List<Artifact> feathers = new ArrayList<>();
    private List<Artifact> hourglasses = new ArrayList<>();
    private List<Artifact> holyGrails = new ArrayList<>();
    private List<Artifact> hats = new ArrayList<>();
}
