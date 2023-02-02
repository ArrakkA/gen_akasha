package play.genshin.akasha.domain.character.dto;

import lombok.Data;

import java.util.List;

@Data
public class EffectiveResponseDTO {
    private String charName;
    private List<String> partyTypes;

    public EffectiveResponseDTO(String charName , List<String> partyTypes){
        this.charName = charName;
        this.partyTypes = partyTypes;
    }

}
