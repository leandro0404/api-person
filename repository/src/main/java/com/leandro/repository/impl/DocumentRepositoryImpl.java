package com.leandro.repository.impl;

import com.leandro.borders.dto.response.Document;
import com.leandro.borders.repository.DocumentRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class DocumentRepositoryImpl extends BaseRepository implements DocumentRepository {
    @Override
    public Mono<List<Document>> findDocumentsByPersonIdsAsync(List<Long> personIds) {
        return get(queryParameters("/documents", personIds), Document.class);
    }
}
