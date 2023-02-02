package play.genshin.akasha.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.artifact.exception.UserNotFoundException;
import play.genshin.akasha.domain.user.entity.User;
import play.genshin.akasha.domain.user.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void FindUser(String userName) {
        Optional<User> byId = userRepository.findById(userName);
        byId.orElseThrow(UserNotFoundException::new);


    }
}
