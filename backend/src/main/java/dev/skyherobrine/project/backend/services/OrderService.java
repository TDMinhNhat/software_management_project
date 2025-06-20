package dev.skyherobrine.project.backend.services;

import dev.skyherobrine.project.backend.dtos.OrderDTO;
import dev.skyherobrine.project.backend.models.mariadb.Order;
import dev.skyherobrine.project.backend.repositories.mariadb.OrderRepository;
import dev.skyherobrine.project.backend.repositories.mariadb.SoftwareRepository;
import dev.skyherobrine.project.backend.repositories.mariadb.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final SoftwareRepository softwareRepository;

    public Mono<Order> orderSoftware(@Valid OrderDTO dto) {
         return orderRepository.save(new Order(
                 userRepository.findUserByUuid(dto.customerId()).block(),
                 softwareRepository.findSoftwareBySoftId(dto.softwareId()).block()
         )).doOnNext(order -> order.getCustomerId().setPassword(""));
    }
}
