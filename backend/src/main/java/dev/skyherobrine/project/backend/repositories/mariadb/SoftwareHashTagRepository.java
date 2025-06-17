package dev.skyherobrine.project.backend.repositories.mariadb;

import dev.skyherobrine.project.backend.keys.SoftwareHashTagKey;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareHashTagRepository extends R2dbcRepository<SoftwareHashTagKey, Integer> {
}
