package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.mariadb.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserDTO(
        @Pattern(regexp = "^[A-Z][a-z]+$", message = "First name must start with an uppercase letter and contain only letters")
        @Size(max = 50, message = "First name must not exceed 50 characters")
        String firstName,
        @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name must start with an uppercase letter and contain only letters")
        @Size(max = 50, message = "Last name must not exceed 50 characters")
        String lastName,
        @Pattern(regexp = "^(true|false)$", message = "The sex property must be true or false")
        Boolean sex,
        @NotNull(message = "The birth date property must be not null")
        LocalDate birthDate,
        @Pattern(regexp = "^\\+?[0-9]{10,20}$", message = "Phone number must be between 10 and 20 digits, optionally starting with a '+'")
        String phoneNumber,
        @Size(max = 500, message = "Address must not exceed 500 characters")
        String address,
        @Pattern(regexp = "^[a-zA-Z0-9._-]{3,30}$", message = "Username must be between 3 and 30 characters and can contain letters, numbers, dots, underscores, and hyphens")
        String username,
        @Email(message = "Email must be a valid email address")
        String email,
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and contain at least one letter and one number")
        String password
) {

    public User toObject() {
        return new User(
                firstName,
                lastName,
                sex,
                birthDate,
                phoneNumber,
                address,
                username,
                email,
                password
        );
    }
}
