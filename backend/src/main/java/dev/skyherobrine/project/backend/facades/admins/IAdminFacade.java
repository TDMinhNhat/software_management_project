package dev.skyherobrine.project.backend.facades.admins;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAdminFacade<S,P> {
    Mono<?> add(S s);
    Mono<?> update(S s, P p);
    Mono<Void> delete(P p);
    Mono<?> getById(P p);
    Flux<?> getAll();
    Flux<?> getAll(int page, int size);
    Flux<?> getAll(String sortBy, String sortDirection);
    Flux<?> getAll(int page, int size, String sortBy, String sortDirection);
}
