package play.genshin.akasha.domain.artifact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.artifact.entity.ArtifactID;

public interface ArtifactRepository extends JpaRepository<Artifact, ArtifactID> {
}
