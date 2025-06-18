package dev.skyherobrine.project.backend.facades.admins.impl;

import dev.skyherobrine.project.backend.dtos.TypeSoftwareDTO;
import dev.skyherobrine.project.backend.exceptions.EntityNotFoundException;
import dev.skyherobrine.project.backend.facades.admins.IAdminFacade;
import dev.skyherobrine.project.backend.repositories.mariadb.TypeSoftwareRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/admin/type_software")
@RequiredArgsConstructor
public class TypeSoftwareFacadeImpl implements IAdminFacade<TypeSoftwareDTO,Long> {

    private final TypeSoftwareRepository typeSoftwareRepository;

    @PostMapping
    @Override
    public Mono<?> add(@Valid @RequestBody TypeSoftwareDTO dto) {
        return typeSoftwareRepository.save(dto.toObject());
    }

    @Override
    public Mono<?> update(TypeSoftwareDTO typeSoftwareDTO, Long aLong) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public Mono<?> delete(@PathVariable("id") Long id) {
        return typeSoftwareRepository.findById(id).switchIfEmpty(Mono.error(new EntityNotFoundException("The type software with ID " + id + " does not exist.")))
                .flatMap(typeSoftware -> {
                    typeSoftware.setStatus(false);
                    return typeSoftwareRepository.save(typeSoftware);
                });
    }

    @GetMapping("/{id}")
    @Override
    public Mono<?> getById(@PathVariable Long id) {
        return typeSoftwareRepository.findById(id).switchIfEmpty(Mono.error(new EntityNotFoundException("The type software with ID " + id + " does not exist.")));
    }

    @GetMapping
    @Override
    public Flux<?> getAll() {
        return typeSoftwareRepository.findAll();
    }

    @Override
    public Flux<?> getAll(int page, int size) {
        return null;
    }

    @Override
    public Flux<?> getAll(String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Flux<?> getAll(int page, int size, String sortBy, String sortDirection) {
        return null;
    }
}
