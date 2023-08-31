package com.leandro.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


public abstract class BaseRepository {

    @Autowired
    protected WebClient webClient;

    public String queryParameters(String path, List<Long> ids) {
        return UriComponentsBuilder.fromPath(path)
                .queryParam("ids", ids.stream().map(Object::toString).collect(Collectors.joining(",")))
                .build()
                .toString();
    }

    public <T> Mono<List<T>> get(String uri, Class<T> itemType) {
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(itemType)
                .collectList();
    }
}
