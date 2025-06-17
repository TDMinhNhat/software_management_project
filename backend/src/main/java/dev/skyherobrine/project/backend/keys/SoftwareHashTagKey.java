package dev.skyherobrine.project.backend.keys;

import dev.skyherobrine.project.backend.models.mariadb.HashTag;
import dev.skyherobrine.project.backend.models.mariadb.Software;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class SoftwareHashTagKey implements Serializable {
    @Column(value = "soft_id")
    private Software software;
    @Column(value = "tag_id")
    private HashTag hashTag;

    public SoftwareHashTagKey(Software software, HashTag hashTag) {
        this.software = software;
        this.hashTag = hashTag;
    }
}
