package dev.skyherobrine.project.backend.models.mariadb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "Software")
@Getter @Setter
@NoArgsConstructor
public class Software {
    @Id
    private Long id;
    @Column(value = "soft_id")
    private String softId;
    private String title;
    private String description;
    @Column(value = "storage_name")
    private String storageName;
    @Column(value = "author_id")
    private User author;
    private BigDecimal price;
    @Column(value = "created_at")
    private Timestamp createdAt;
    @Column(value = "updated_at")
    private Timestamp updatedAt;
    private boolean status;

    public Software(String softId, String title, String description, String storageName, User author, BigDecimal price) {
        this.softId = softId;
        this.title = title;
        this.description = description;
        this.storageName = storageName;
        this.author = author;
        this.price = price;
        this.createdAt = this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
        this.status = true;
    }

    public Software(String title, String description, String storageName, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.storageName = storageName;
        this.price = price;
    }
}
