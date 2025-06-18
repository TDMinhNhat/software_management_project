package dev.skyherobrine.project.backend.facades;

import dev.skyherobrine.project.backend.dtos.UserDTO;
import dev.skyherobrine.project.backend.exceptions.EntityNotFoundException;
import dev.skyherobrine.project.backend.models.mariadb.User;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/authenticate")
@AllArgsConstructor
public class AuthenticateFacade {

    private final UserRepository userRepository;

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
        return null;
    }
}
