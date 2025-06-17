package dev.skyherobrine.project.backend.repositories.mariadb;

import dev.skyherobrine.project.backend.models.mariadb.TypeSoftware;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSoftwareRepository extends R2dbcRepository<TypeSoftware,Long> {
}
