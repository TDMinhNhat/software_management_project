package dev.skyherobrine.project.backend.models.mongodb;

import dev.skyherobrine.project.backend.models.mariadb.Software;
import dev.skyherobrine.project.backend.models.mariadb.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Document(collection = "SoftwareReview")
@Getter @Setter
@NoArgsConstructor
public class SoftwareReview {
    @MongoId
    private Long id;
    private User reviewer;
    private Software software;
    private String content;
    private int rating;
    @Field(name = "created_at")
    private Timestamp createdAt;
    @Field(name = "updated_at")
    private Timestamp updatedAt;

    public SoftwareReview(Long id, User reviewer, Software software, String content, int rating) {
        this.id = id;
        this.reviewer = reviewer;
        this.software = software;
        this.content = content;
        this.rating = rating;
        this.createdAt = this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
