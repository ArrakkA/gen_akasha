package play.genshin.akasha.domain.artifact.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import play.genshin.akasha.domain.artifact.dto.ArtifactRequestDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    public Artifact(ArtifactRequestDTO requestDTO, int artifactNo) {
        this.userName = requestDTO.getUserName();
        this.artifactCd = requestDTO.getArtifactCd();
        this.artifactPart = requestDTO.getArtifactPart();
        this.artifactNo = artifactNo;
        this.mainOption = requestDTO.getMainOption();
        this.attack = requestDTO.getAttack();
        this.attackPer = requestDTO.getAttackPer();
        this.defense = requestDTO.getDefense();
        this.defensePer = requestDTO.getDefensePer();
        this.healthPoint = requestDTO.getHealthPoint();
        this.healthPointPer = requestDTO.getHealthPointPer();
        this.elementMastery = requestDTO.getElementMastery();
        this.elementCharge = requestDTO.getElementCharge();
        this.criticalProbability = requestDTO.getCriticalProbability();
        this.criticalDamage = requestDTO.getCriticalDamage();
        this.useYn = "N";
    }

    @Override
    public ArtifactID getId() {
        return new ArtifactID(userName, artifactCd, artifactPart, artifactNo);
    }

    @Override
    public boolean isNew() {
        return upDate == null;
    }
}
