package dev.skyherobrine.project.backend.repositories.mariadb;

import dev.skyherobrine.project.backend.models.mariadb.HashTag;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagRepository extends R2dbcRepository<HashTag,Long> {
}
