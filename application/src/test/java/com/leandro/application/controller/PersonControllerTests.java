package com.leandro.application.controller;


import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.leandro.application.config.ApplicationTestConfiguration;
import com.leandro.application.util.ResourceGraphQl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationTestConfiguration.class)
@DisplayName("person tests")
public class PersonControllerTests {


    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;


    @SneakyThrows
    @ParameterizedTest(name = "{displayName}")
    @ValueSource(strings = {"people"})
    @DisplayName("find {arguments} success return results")
    void findSuccess(String name) {

        //arrange
        //act
        var response = graphQLTestTemplate
                .postForResource(ResourceGraphQl.path(name));

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertEquals(name, response.getRawResponse().getBody(), ResourceGraphQl.json(name));
    }

}
