package com.leandro.borders.repository;

import com.leandro.borders.dto.response.Document;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DocumentRepository {
    Mono<List<Document> > findDocumentsByPersonIdsAsync(List<Long> personIds);
}
