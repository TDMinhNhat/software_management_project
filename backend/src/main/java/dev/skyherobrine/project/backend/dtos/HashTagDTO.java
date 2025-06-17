package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.mariadb.HashTag;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record HashTagDTO(
        @Pattern(regexp = "^[a-zA-Z0-9_]{1,20}$", message = "Tag name must be alphanumeric and up to 20 characters long")
        String tagName,
        @Size(max = 1000, message = "The description of hashtag must be less than 1000 characters")
        String description
) {

    public HashTag toObject() {
        return new HashTag(this.tagName, this.description);
    }
}
