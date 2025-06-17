package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.mariadb.UserRole;
import jakarta.validation.constraints.Pattern;

public record UserRoleDTO(
        @Pattern(regexp = "[A-Za-z ]+", message = "The role name contains only characters and must be not null")
        String roleName) {

    public UserRole toObject() {
        return new UserRole(this.roleName);
    }
}
