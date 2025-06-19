package dev.skyherobrine.project.backend.facades;

import dev.skyherobrine.project.backend.dtos.SoftwareDTO;
import dev.skyherobrine.project.backend.models.mariadb.Software;
import dev.skyherobrine.project.backend.repositories.mariadb.SoftwareRepository;
import dev.skyherobrine.project.backend.services.SoftwareService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/software")
@RequiredArgsConstructor
public class SoftwareFacade {

    private final SoftwareRepository softwareRepository;
    private final SoftwareService softwareService;

    @PostMapping
    public Mono<Software> addSoftware(@Valid @RequestBody SoftwareDTO dto) {
        return softwareService.addSoftware(dto);
    }

    @PutMapping("/{id}")
    public Mono<Software> updateSoftware(@PathVariable("id") String softId, @Valid @RequestBody SoftwareDTO dto) {
        return softwareService.updateSoftware(softId, dto);
    }

    @GetMapping
    public Flux<Software> getAll() {
        return softwareRepository.findAll()
                .doOnEach(soft -> soft.get().getAuthor().setPassword(""));
    }

    @GetMapping("/page")
    public Flux<Software> getAll(
            @Valid
            @Min(value = 1, message = "Page number must be greater than or equal to 1")
            @RequestParam Long page,
            @Valid
            @Min(value = 1, message = "Page size must be greater than or equal to 1")
            @RequestParam Long size) {
        return softwareRepository.findAll()
                .skip(page * size)
                .take(size)
                .doOnEach(soft -> soft.get().getAuthor().setPassword(""));
    }
}
