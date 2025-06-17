package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.mariadb.TypeSoftware;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TypeSoftwareDTO(
        @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Type name must be alphanumeric and not be empty or null")
        String typeName,
        @Size(max = 1000, message = "The description of type software must be less than 1000 characters")
        String description
) {

    public TypeSoftware toObject() {
        return new TypeSoftware(this.typeName, this.description);
    }
}
