package com.leandro.repository;

import com.leandro.borders.dto.response.Person;
import com.leandro.repository.impl.PersonRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class PersonRepositoryImplTest {

    @Mock
    private WebClient.Builder webClientBuilder;
    @Mock
    private WebClient webClient;
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    @Mock
    private WebClient.ResponseSpec responseSpec;
    @InjectMocks
    private PersonRepositoryImpl personRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString(), (Object) any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void findPeopleByIdsAsync_ShouldReturnListOfPeople() {
        // Arrange
        List<Long> ids = Collections.singletonList(1L);
        Person person = new Person();

        when(responseSpec.bodyToFlux(eq(Person.class))).thenReturn(Flux.just(person));

        // Act
        Mono<List<Person>> result = personRepository.findPeopleByIdsAsync(ids);

        // Assert
        StepVerifier.create(result)
                .assertNext(persons -> {
                    assertEquals(1, persons.size());
                    assertEquals(person, persons.get(0));
                })
                .verifyComplete();
    }
}
