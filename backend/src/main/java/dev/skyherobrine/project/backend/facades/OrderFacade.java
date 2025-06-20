package dev.skyherobrine.project.backend.facades;

import dev.skyherobrine.project.backend.dtos.OrderDTO;
import dev.skyherobrine.project.backend.models.mariadb.Order;
import dev.skyherobrine.project.backend.repositories.mariadb.OrderRepository;
import dev.skyherobrine.project.backend.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @PostMapping
    public Mono<Order> orderSoftware(@Valid @RequestBody OrderDTO dto) {
        return orderService.orderSoftware(dto);
    }

    @GetMapping("/customer/{custUUID}")
    public Flux<Order> getOrdersByCustUUID(@PathVariable("custUUID") String custUUID) {
        return orderRepository.findOrdersByCustomerId_Uuid(custUUID).doOnNext(order -> order.getCustomerId().setPassword(""));
    }
}
