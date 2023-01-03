package play.genshin.akasha.domain.artifact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "artefact")
@IdClass(ArtifactID.class)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Artifact implements Persistable<ArtifactID> {
    @Id
    private String userName;
    @Id
    private int artifactCd;
    @Id
    private String artifactPart;
    @Id
    private int artifactNo;

    private String mainOption;
    private double mainValue;

    private double attack;
    private double attackPer;
    private double defense;
    private double defensePer;
    private double healthPoint;
    private double healthPointPer;
    private double elementMastery;
    private double elementCharge;
    private double criticalProbability;
    private double criticalDamage;

    private String useYn;
    @LastModifiedDate
    private LocalDateTime upDate;

    @Override
    public ArtifactID getId() {
        return new ArtifactID(userName, artifactCd, artifactPart, artifactNo);
    }

    @Override
    public boolean isNew() {
        return upDate == null;
    }
}
