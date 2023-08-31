package com.leandro.borders.repository;

import com.leandro.borders.dto.response.Address;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AddressRepository {
   Mono< List<Address>> findAddressesByPersonIdsAsync(List<Long> personIds);
}
