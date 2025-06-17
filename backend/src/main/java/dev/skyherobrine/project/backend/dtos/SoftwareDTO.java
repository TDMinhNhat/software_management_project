package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.mariadb.Software;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record SoftwareDTO(
        @Size(max = 200, message = "The title must not exceed 200 characters")
        String title,
        @Size(max = 1000, message = "The description must not exceed 1000 characters")
        String description,
        @NotBlank(message = "The author id must be exists")
        String authorId,
        BigDecimal price
) {

}
