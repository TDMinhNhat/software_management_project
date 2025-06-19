package dev.skyherobrine.project.backend.projects;

import dev.skyherobrine.project.backend.enums.UserStatus;
import dev.skyherobrine.project.backend.models.mariadb.UserRole;

import java.sql.Timestamp;
import java.time.LocalDate;

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
    private String password;
    private UserRole role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserStatus status;
}
