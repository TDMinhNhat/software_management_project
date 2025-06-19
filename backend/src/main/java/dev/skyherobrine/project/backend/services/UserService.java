package dev.skyherobrine.project.backend.services;

import dev.skyherobrine.project.backend.dtos.UserDTO;
import dev.skyherobrine.project.backend.models.mariadb.User;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRepository;
import dev.skyherobrine.project.backend.utils.CopyPropertyObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> updateUserInfo(String userUUID, @Valid UserDTO dto) {
        return Mono.just(userRepository.findUserByUuid(userUUID)
                .doOnNext(user -> CopyPropertyObject.copyProperties(dto, user))
                .doOnNext(userRepository::save)
                .block()
        );
    }
}
