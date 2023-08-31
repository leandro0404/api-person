package com.leandro.repository.impl;

import com.leandro.borders.dto.response.Address;
import com.leandro.borders.repository.AddressRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class AddressRepositoryImpl extends BaseRepository implements AddressRepository {

    public Mono<List<Address>> findAddressesByPersonIdsAsync(List<Long> personIds) {
        return get(queryParameters("/addresses", personIds), Address.class);
    }
}
