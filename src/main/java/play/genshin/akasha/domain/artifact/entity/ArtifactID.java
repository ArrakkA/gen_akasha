package play.genshin.akasha.domain.artifact.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
public class ArtifactID implements Serializable {
    private String userName;
    private int artifactCd;
    private String artifactPart;
    private int artifactNo;
}
