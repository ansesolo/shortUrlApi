package com.gmail.alf.miniapi.controllers;

import com.gmail.alf.miniapi.entities.ShortUrl;
import com.gmail.alf.miniapi.exceptions.ResourceNotFoundException;
import com.gmail.alf.miniapi.services.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

/**
 * Controller which manage URL request for the api.
 * Validated is used to validate parameters request
 */
@Validated
@RestController
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @GetMapping("api/v1/short_url")
    public ResponseEntity<List<ShortUrl>> findAllShortURLs() {

        List<ShortUrl> shorUrls = shortUrlService.findAllShortUrls();

        return new ResponseEntity<>(shorUrls, HttpStatus.OK);
    }

    @GetMapping("api/v1/short_url/{id}")
    public ResponseEntity<ShortUrl> findShortURLById(@PathVariable(value = "id") long id) {
        try {
            ShortUrl shortUrl = shortUrlService.findShortUrlById(id);
            return ResponseEntity.ok().body(shortUrl);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("api/v1/short_url")
    public ResponseEntity<ShortUrl> createShortUrl(@Valid @RequestBody ShortUrl shortURL) {
        return new ResponseEntity<>(shortUrlService.createShortUrl(shortURL), HttpStatus.CREATED);
    }

    @PutMapping("api/v1/short_url/{id}")
    public ResponseEntity<ShortUrl> updateShortUrl(@PathVariable(value = "id") long id, @Valid @RequestBody ShortUrl shortURL) {
        try {
            ShortUrl updatedShortUrl = shortUrlService.updateShortUrl(id, shortURL);
            return ResponseEntity.ok().body(updatedShortUrl);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("api/v1/short_url/{id}")
    public ResponseEntity<ShortUrl> deleteShortUrl(@PathVariable(value = "id") long id) {
        try {
            shortUrlService.deleteShortUrl(id);
            return ResponseEntity.ok().build();

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public String home() {
        return "Application mini api! <br> Use api/v1/short_url or /[shorturl]";
    }

    @GetMapping("{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable(value = "shortUrl") @NotNull String shortUrl) {
        try {
            String url = shortUrlService.getFullUrl(shortUrl);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
