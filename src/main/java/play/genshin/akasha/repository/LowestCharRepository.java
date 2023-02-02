package play.genshin.akasha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import play.genshin.akasha.domain.character.entity.LowestCharID;
import play.genshin.akasha.domain.character.entity.LowestCharacter;

public interface LowestCharRepository extends JpaRepository<LowestCharacter, LowestCharID> {

}
