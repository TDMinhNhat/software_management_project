package dev.skyherobrine.project.backend.services;

import dev.skyherobrine.project.backend.dtos.SoftwareDTO;
import dev.skyherobrine.project.backend.exceptions.EntityNotFoundException;
import dev.skyherobrine.project.backend.models.mariadb.Software;
import dev.skyherobrine.project.backend.models.mariadb.User;
import dev.skyherobrine.project.backend.repositories.mariadb.SoftwareRepository;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SoftwareService {

    private final SoftwareRepository softwareRepository;
    private final UserRepository userRepository;

    public Mono<Software> addSoftware(SoftwareDTO dto) {
        return Mono.just(new Software(
                        generateSoftwareId(),
                        dto.title(),
                        dto.description(),
                        null,
                        userRepository.findUserByUuid(dto.authorId())
                                .switchIfEmpty(Mono.error(new EntityNotFoundException("Author not found"))).block(),
                        dto.price())
        ).flatMap(softwareRepository::save)
                .doOnNext(software -> software.getAuthor().setPassword(""));
    }

    public Mono<Software> updateSoftware(String softId, SoftwareDTO dto) {
        return Mono.just(softwareRepository.findSoftwareBySoftId(softId)
                .switchIfEmpty(Mono.error(new EntityNotFoundException("The soft id " + softId + " wasn't found!")))
                .doOnNext(soft -> {
                    soft.setTitle(dto.title());
                    soft.setDescription(dto.description());
                    soft.setPrice(dto.price());
                })
                .flatMap(softwareRepository::save)
                .doOnNext(software -> software.getAuthor().setPassword(""))
                .block());
    }

    private String generateSoftwareId() {
        return null;
    }

}
