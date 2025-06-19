package dev.skyherobrine.project.backend.repositories.mariadb;

import dev.skyherobrine.project.backend.models.mariadb.Software;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SoftwareRepository extends R2dbcRepository<Software,Long> {
    Mono<Software> findSoftwareBySoftId(String softId);
}
