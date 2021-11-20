package com.gmail.alf.miniapi.services;

import com.gmail.alf.miniapi.entities.ShortUrl;

import java.util.List;

public interface ShortUrlService {

    List<ShortUrl> findAllShortURLs();

    ShortUrl findShortURLById(long id);

    ShortUrl createShortUrl(ShortUrl shortURL);

    ShortUrl updateShortUrl(long id, ShortUrl shortURL);

    void deleteShortUrl(Long id);
}
