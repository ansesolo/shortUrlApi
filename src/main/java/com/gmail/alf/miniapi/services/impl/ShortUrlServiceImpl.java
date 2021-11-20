package com.gmail.alf.miniapi.services.impl;
import com.gmail.alf.miniapi.entities.ShortUrl;
import com.gmail.alf.miniapi.exceptions.ResourceNotFoundException;
import com.gmail.alf.miniapi.repositories.ShortUrlRepository;
import com.gmail.alf.miniapi.services.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    @Autowired
    private ShortUrlRepository sortUrlRepository;

    @Override
    public List<ShortUrl> findAllShortURLs() {
        return (List<ShortUrl>) sortUrlRepository.findAll();
    }

    @Override
    public ShortUrl findShortURLById(long id) throws ResourceNotFoundException {
        Optional<ShortUrl> shortUrl = sortUrlRepository.findById(id);

        if (shortUrl.isPresent()) {
            return shortUrl.get();
        } else {
            throw new ResourceNotFoundException(ShortUrl.class.getSimpleName(), id);
        }
    }

    @Override
    public ShortUrl createShortUrl(ShortUrl shortURL) {
        return sortUrlRepository.save(shortURL);
    }

    @Override
    public ShortUrl updateShortUrl(long id, ShortUrl shortUrl) {

        try {
            ShortUrl shortUrlToUpdate = findShortURLById(id);
            shortUrlToUpdate.setShortUrl(shortUrl.getShortUrl());
            shortUrlToUpdate.setUrl(shortUrl.getUrl());

            return sortUrlRepository.save(shortUrl);

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(ShortUrl.class.getSimpleName(), id);
        }
    }

    @Override
    public void deleteShortUrl(Long id) {
        try {
            ShortUrl shortUrlToDelete = findShortURLById(id);
            sortUrlRepository.delete(shortUrlToDelete);

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(ShortUrl.class.getSimpleName(), id);
        }
    }
}
