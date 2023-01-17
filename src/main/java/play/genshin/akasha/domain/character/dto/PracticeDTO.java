package play.genshin.akasha.domain.character.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PracticeDTO {
    private String charName;
    private String partyType;

    @QueryProjection
    public PracticeDTO(String charName, String partyType) {
        this.charName = charName;
        this.partyType = partyType;
    }
}
