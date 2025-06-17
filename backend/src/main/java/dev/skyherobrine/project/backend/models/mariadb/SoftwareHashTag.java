package dev.skyherobrine.project.backend.models.mariadb;

import dev.skyherobrine.project.backend.keys.SoftwareHashTagKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "SoftwareHashTag")
@Getter @Setter
@NoArgsConstructor
public class SoftwareHashTag {
    @Id @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private SoftwareHashTagKey id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean status;

    public SoftwareHashTag(SoftwareHashTagKey id) {
        this.id = id;
        this.createdAt = this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
        this.status = true;
    }
}
