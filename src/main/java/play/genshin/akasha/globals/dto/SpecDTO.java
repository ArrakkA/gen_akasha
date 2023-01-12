package play.genshin.akasha.globals.dto;


import lombok.Data;
import play.genshin.akasha.domain.character.entity.LowestCharacter;

import java.util.ArrayList;
import java.util.List;


@Data
public class SpecDTO {
    private String charName;
    private List<Setting> settings = new ArrayList<>();


    public SpecDTO(String charName){
        this.charName = charName;
    }

    public SpecDTO(String charName, List<Setting> settings){
        this.charName = charName;
        this.settings = settings;
    }

    @Data
    public static class Setting{
        private String partyType;
        private List<String> weapon = new ArrayList<>();

        public Setting(String partyType, List<String> weapon){
            this.partyType = partyType;
            this.weapon = weapon;
        }

        public Setting(String partyType){
            this.partyType = partyType;
        }


    }

}
