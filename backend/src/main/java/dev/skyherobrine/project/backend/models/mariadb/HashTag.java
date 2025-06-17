package dev.skyherobrine.project.backend.models.mariadb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "HashTag")
@Getter @Setter
@NoArgsConstructor
public class HashTag {
    @Id
    private Long id;
    @Column(value = "tag_name")
    private String tagName;
    private String description;
    private boolean status;
    private Timestamp createdAt;

    public HashTag(String tagName, String description) {
        this.tagName = tagName;
        this.description = description;
        this.status = true;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
