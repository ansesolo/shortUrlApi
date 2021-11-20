package com.gmail.alf.miniapi.repositories;

import com.gmail.alf.miniapi.entities.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {
}
