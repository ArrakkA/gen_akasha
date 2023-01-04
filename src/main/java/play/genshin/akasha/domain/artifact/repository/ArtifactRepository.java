package play.genshin.akasha.domain.artifact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.artifact.entity.ArtifactID;

public interface ArtifactRepository extends JpaRepository<Artifact, ArtifactID> {


    @Query("select coalesce(a.artifactNo, 0) from Artifact a " +
            "where a.artifactCd = :artifactCd " +
            "  and a.userName = :userName ")
    int findArtifactNo(@Param("artifactCd")int artifactCd, @Param("userName")String userName);

}
