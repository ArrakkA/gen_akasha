package play.genshin.akasha.domain.character.dto.registry;

import lombok.Data;

@Data
public class CharStandardRequestDTO {
    private String charName;
    private String partyType;               //"딜러", "서포터" , "확산" ,"물리" , "격변" , "빙결" , "융해"
    private String validMain;               //"고공" , "고체" , "공퍼", "체퍼", "방퍼" , "치유" ,"원마", "원충" ,"치확", "치피" , "물리피" "불원피", "물원피" , "바위원피", "바람원피", "번원피" , "얼원피" , "풀원피"
    private String artifactPart;            // "꽃" , "깃털" , "시계" , "성배" , "왕관"

    private String attack;                  //"Y" , "N"
    private String defense;
    private String healthPoint;
    private String elementMastery;
    private String elementCharge;
    private String criticalDamage;
}
