package com.gmail.alf.miniapi.services;

import com.gmail.alf.miniapi.entities.ShortUrl;

import java.util.List;

public interface ShortUrlService {

    List<ShortUrl> findAllShortUrls();

    ShortUrl findShortUrlById(long id);

    ShortUrl createShortUrl(ShortUrl shortURL);

    ShortUrl updateShortUrl(long id, ShortUrl shortURL);

    void deleteShortUrl(Long id);

    String getFullUrl(String id);
}
