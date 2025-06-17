package dev.skyherobrine.project.backend.models.mariadb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "TypeSoftware")
@Getter @Setter
@NoArgsConstructor
public class TypeSoftware {
    @Id
    private Long id;
    @Column(value = "type_name")
    private String typeName;
    private String description;
    private boolean status;
    private Timestamp createdAt;

    public TypeSoftware(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
        this.status = true;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
