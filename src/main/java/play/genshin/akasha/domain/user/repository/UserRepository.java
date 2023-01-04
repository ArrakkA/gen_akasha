package play.genshin.akasha.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import play.genshin.akasha.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
