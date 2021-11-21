package com.gmail.alf.miniapi.repositories;

import com.gmail.alf.miniapi.entities.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository which extends spring crud repository to facilitate the implementation of new method.
 * The advantage is that we can declare method that spring will automatically implement.
 */
@Repository
public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {

    ShortUrl findByShortUrl(String shortUrl);
}
