package com.leandro.borders.repository;

import com.leandro.borders.dto.response.Phone;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PhoneRepository {
    Mono<List<Phone>> findPhonesByPersonIdsAsync(List<Long> personIds);
}
