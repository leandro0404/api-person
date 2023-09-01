package com.leandro.application.util;

import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

public class ResourceGraphQl {

    private static final String GRAPHQL_QUERY_REQUEST_PATH = "integration/%s.graphql";
    private static final String GRAPHQL_QUERY_RESPONSE_PATH = "integration/mock/%s.json";


    public static String path(final String fileName) {
        return format(GRAPHQL_QUERY_REQUEST_PATH, fileName);
    }

    public static String json(String fileName) throws IOException {
        return read(format(GRAPHQL_QUERY_RESPONSE_PATH, fileName));
    }

    private static String read(final String location) throws IOException {
        return IOUtils.toString(
                new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
    }
}
