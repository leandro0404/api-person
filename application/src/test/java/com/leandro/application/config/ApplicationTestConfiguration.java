package com.leandro.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leandro.application.util.ResourceGraphQl;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@TestConfiguration
public class ApplicationTestConfiguration {

    @Bean
    @Primary
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @Primary

    public WebClient webClientTest(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        return webClientBuilder.baseUrl("http://localhost:3000/")
                .exchangeFunction(clientRequest -> {
                    return Mono.just(ClientResponse.create(HttpStatus.OK)
                            .header("Content-Type", "application/json")
                            .body(getResourcePath(clientRequest))
                            .build());

                })
                .build();
    }

    @SneakyThrows
    private String getResourcePath(ClientRequest clientRequest) {
        return ResourceGraphQl.json(clientRequest.url().getPath());
    }

}
