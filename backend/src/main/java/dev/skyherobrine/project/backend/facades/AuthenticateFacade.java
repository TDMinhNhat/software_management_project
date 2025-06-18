package dev.skyherobrine.project.backend.facades;

import dev.skyherobrine.project.backend.dtos.UserDTO;
import dev.skyherobrine.project.backend.exceptions.EntityNotFoundException;
import dev.skyherobrine.project.backend.models.mariadb.User;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRepository;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRoleRepository;
import dev.skyherobrine.project.backend.utils.EncodeDecodeUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/v1/authenticate")
@AllArgsConstructor
public class AuthenticateFacade {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @PostMapping("/login")
    public Mono<User> checkLogin(
            @RequestParam("account") String account,
            @RequestParam("password") String password
    ) {
        return userRepository.findUserByEmailOrUsernameAndPassword(account, account, password)
                .switchIfEmpty(Mono.error(new EntityNotFoundException("The account or password is incorrect.")));
    }

    @PostMapping("/register")
    public Mono<User> registerAccount(@Valid @RequestBody UserDTO dto) {
        return Mono.just(dto.toObject()).flatMap(user -> {
            user.setPassword(EncodeDecodeUtil.encode(user.getPassword()));
            user.setRole(userRoleRepository
                    .findByRoleName("USER")
                    .switchIfEmpty(Mono.error(new EntityNotFoundException("The 'User' role doesn't exist in system.")))
                    .block());
            return userRepository.save(user);
        });
    }

    @PostMapping("/reset_password")
    public Mono<Boolean> resetPassword(@RequestParam String email) {
        return userRepository.findUserByEmail(email).switchIfEmpty(Mono.error(new EntityNotFoundException("This email isn't registered.")))
                .flatMap(user -> {
                    user.setPassword(EncodeDecodeUtil.encode(String.valueOf(123456789)));
                    return userRepository.save(user);
                }).hasElement();
    }
}
