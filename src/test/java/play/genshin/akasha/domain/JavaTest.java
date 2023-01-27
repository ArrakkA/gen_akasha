package play.genshin.akasha.domain;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import play.genshin.akasha.globals.common.Globals;
import play.genshin.akasha.globals.dto.SpecDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
@SpringBootTest
public class JavaTest {

    @Test
    public void test() {
        List<SpecDTO> collect = Globals.characterSpec.stream()
                .collect(groupingBy(c -> new SpecDTO(c.getCharName()),
                        mapping(c -> new SpecDTO.Setting(c.getPartyType(), c.getWeapon()), toList())))
                .entrySet().stream()
                .map(e -> new SpecDTO(e.getKey().getCharName(), e.getValue()))
                .collect(toList());


        for (SpecDTO specDTO : collect) {
            System.out.println("specDTO.getCharName = " + specDTO.getCharName());
            for (SpecDTO.Setting setting : specDTO.getSettings()) {
                System.out.println("setting.getPartyType() = " + setting.getPartyType());
                for (String s : setting.getWeapon()) {
                    System.out.println("s = " + s);
                }

            }

        }

    }
}
