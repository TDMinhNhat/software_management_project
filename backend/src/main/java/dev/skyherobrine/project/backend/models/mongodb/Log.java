package dev.skyherobrine.project.backend.models.mongodb;

import dev.skyherobrine.project.backend.enums.LogStatus;
import dev.skyherobrine.project.backend.models.mariadb.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Document(collection = "Log")
@Getter @Setter
@NoArgsConstructor
public class Log {
    @MongoId
    private Long id;
    private User user;
    @Field(name = "action_type")
    private String actionType;
    @Field(name = "action_detail")
    private String actionDetail;
    @Field(name = "created_at")
    private Timestamp createdAt;
    private LogStatus status;
}
