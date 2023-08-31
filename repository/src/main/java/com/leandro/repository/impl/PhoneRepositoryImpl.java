package com.leandro.repository.impl;

import com.leandro.borders.dto.response.Phone;
import com.leandro.borders.repository.PhoneRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class PhoneRepositoryImpl extends BaseRepository implements PhoneRepository {
    @Override
    public Mono<List<Phone>> findPhonesByPersonIdsAsync(List<Long> personIds) {
        return get(queryParameters("/phones", personIds), Phone.class);
    }
}
