package dev.skyherobrine.project.backend.models.mariadb;

import dev.skyherobrine.project.backend.enums.UserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "User")
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String uuid;
    @Column(value = "first_name")
    private String firstName;
    @Column(value = "last_name")
    private String lastName;
    private boolean sex;
    @Column(value = "birth_date")
    private LocalDate birthDate;
    @Column(value = "phone_number")
    private String phoneNumber;
    private String address;
    private String username;
    private String email;
    private String password;
    private UserRole role;
    @Column(value = "created_at")
    private Timestamp createdAt;
    @Column(value = "updated_at")
    private Timestamp updatedAt;
    private UserStatus status;

    public User(String uuid, String firstName, String lastName, boolean sex, LocalDate birthDate, String phoneNumber, String address, String username, String email, String password, UserRole role) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
        this.status = UserStatus.ACTIVE;
    }
}
