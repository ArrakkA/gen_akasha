package play.genshin.akasha.domain.character.standard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class EffectiveResponseDTO {

    private String charName;
    private List<String> partyType = new ArrayList<>();

    public EffectiveResponseDTO(EffectiveDTO dto){
        charName = dto.getCharName();
        partyType.add(dto.getPartyType());
    }




}
