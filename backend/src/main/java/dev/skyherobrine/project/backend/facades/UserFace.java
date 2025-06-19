package dev.skyherobrine.project.backend.facades;

import dev.skyherobrine.project.backend.dtos.UserDTO;
import dev.skyherobrine.project.backend.models.mariadb.User;
import dev.skyherobrine.project.backend.projects.UserProject;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRepository;
import dev.skyherobrine.project.backend.services.UserService;
import dev.skyherobrine.project.backend.utils.CopyPropertyObject;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserFace {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/info")
    public Mono<UserProject> getUserInfo(@RequestParam("uuid") String userUUID) {
        return userRepository.findUserByUuid(userUUID)
                .flatMap(user -> Mono.just((UserProject) CopyPropertyObject.copyProperties(new UserProject(), user)));
    }

    @PutMapping("/update/{uuid}")
    public Mono<User> updateUserInfo(
            @PathVariable("uuid") String userUUID,
            @Valid @RequestBody UserDTO dto) {
        return userService.updateUserInfo(userUUID, dto);
    }
}
