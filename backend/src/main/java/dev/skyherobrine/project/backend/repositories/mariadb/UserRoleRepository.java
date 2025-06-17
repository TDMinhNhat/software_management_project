package dev.skyherobrine.project.backend.repositories.mariadb;

import dev.skyherobrine.project.backend.models.mariadb.UserRole;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends R2dbcRepository<UserRole,Long> {
}
