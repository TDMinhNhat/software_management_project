package dev.skyherobrine.project.backend.models.mariadb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "UserRole")
@Getter @Setter
@NoArgsConstructor
public class UserRole {
    @Id
    private Long id;
    @Column(value = "role_name")
    private String roleName;
    private boolean status;
    private LocalDateTime createdAt;

    public UserRole(String roleName) {
        this.roleName = roleName;
        this.createdAt = LocalDateTime.now();
    }
}
