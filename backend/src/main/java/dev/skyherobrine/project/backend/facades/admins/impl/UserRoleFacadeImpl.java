package dev.skyherobrine.project.backend.facades.admins.impl;

import dev.skyherobrine.project.backend.dtos.UserRoleDTO;
import dev.skyherobrine.project.backend.exceptions.EntityNotFoundException;
import dev.skyherobrine.project.backend.facades.admins.IAdminFacade;
import dev.skyherobrine.project.backend.models.mariadb.UserRole;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRoleRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/admin/user_role")
@AllArgsConstructor
public class UserRoleFacadeImpl implements IAdminFacade<UserRoleDTO,Long> {

    private final UserRoleRepository userRoleRepository;

    @PostMapping
    @Override
    public Mono<UserRole> add(@Valid @RequestBody UserRoleDTO userRoleDTO) {
        return userRoleRepository.save(userRoleDTO.toObject());
    }

    @PutMapping("/{id}")
    @Override
    public Mono<UserRole> update(@Valid @RequestBody UserRoleDTO userRoleDTO, @PathVariable("id") Long id) {
        return userRoleRepository.findById(id).switchIfEmpty(
                Mono.error(new EntityNotFoundException("The user role with ID " + id + " does not exist."))
        ).flatMap(exist -> {
            exist.setRoleName(userRoleDTO.roleName());
            return userRoleRepository.save(exist);
        });
    }

    @DeleteMapping("/{id}")
    @Override
    public Mono<?> delete(@PathVariable("id") Long id) {
        return userRoleRepository.delete(
                Objects.requireNonNull(Objects.requireNonNull(userRoleRepository.findById(id).switchIfEmpty(
                        Mono.error(new EntityNotFoundException("The user role with ID " + id + " does not exist."))
                )).block())
        );
    }

    @GetMapping("/{id}")
    @Override
    public Mono<UserRole> getById(Long id) {
        return userRoleRepository.findById(id).switchIfEmpty(
                Mono.error(new EntityNotFoundException("The user role with ID " + id + " does not exist."))
        );
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Override
    public Flux<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Flux<UserRole> getAll(int page, int size) {
        return null;
    }

    @Override
    public Flux<UserRole> getAll(String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Flux<UserRole> getAll(int page, int size, String sortBy, String sortDirection) {
        return null;
    }
}
