package dev.skyherobrine.project.backend.projects;

import dev.skyherobrine.project.backend.enums.UserStatus;
import dev.skyherobrine.project.backend.models.mariadb.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserProject {
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private boolean sex;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
    private String username;
    private String email;
    private UserRole role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserStatus status;
}
