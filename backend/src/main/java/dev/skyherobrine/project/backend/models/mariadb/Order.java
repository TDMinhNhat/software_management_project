package dev.skyherobrine.project.backend.models.mariadb;

import dev.skyherobrine.project.backend.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "Order")
@Getter @Setter
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    @Column(value = "cust_id")
    private User customerId;
    @Column(value = "soft_id")
    private Software softwareId;
    @Column(value = "order_date")
    private Timestamp orderDate;
    private OrderStatus status;

    public Order(User customerId, Software softwareId) {
        this.customerId = customerId;
        this.softwareId = softwareId;
        this.orderDate = Timestamp.valueOf(LocalDateTime.now());
        this.status = OrderStatus.PENDING;
    }
}
