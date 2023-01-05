package play.genshin.akasha.domain.artifact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.artifact.entity.ArtifactID;

import java.util.List;

public interface ArtifactRepository extends JpaRepository<Artifact, ArtifactID> {
    @Query("select coalesce(max(a.artifactNo), 0) from Artifact a " +
            "where a.userName = :userName ")
    int findArtifactNo(@Param("userName")String userName);

    List<Artifact> findArtifactByUserName(String userName);


}
