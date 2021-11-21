package com.gmail.alf.miniapi.controllers;

import com.gmail.alf.miniapi.entities.ShortUrl;
import com.gmail.alf.miniapi.exceptions.ResourceIntegrityException;
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

    @GetMapping("short_url")
    public ResponseEntity<List<ShortUrl>> findAllShortURLs() {

        List<ShortUrl> shorUrls = shortUrlService.findAllShortUrls();

        return new ResponseEntity<>(shorUrls, HttpStatus.OK);
    }

    @GetMapping("short_url/{id}")
    public ResponseEntity<?> findShortURLById(@PathVariable(value = "id") long id) {
        try {
            ShortUrl shortUrl = shortUrlService.findShortUrlById(id);
            return ResponseEntity.ok().body(shortUrl);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("short_url")
    public ResponseEntity<?> createShortUrl(@Valid @RequestBody ShortUrl shortURL) {
        try {
            return new ResponseEntity<>(shortUrlService.createShortUrl(shortURL), HttpStatus.CREATED);
        } catch (ResourceIntegrityException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("short_url/{id}")
    public ResponseEntity<?> updateShortUrl(@PathVariable(value = "id") long id, @Valid @RequestBody ShortUrl shortURL) {
        try {
            ShortUrl updatedShortUrl = shortUrlService.updateShortUrl(id, shortURL);
            return ResponseEntity.ok().body(updatedShortUrl);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("short_url/{id}")
    public ResponseEntity<?> deleteShortUrl(@PathVariable(value = "id") long id) {
        try {
            shortUrlService.deleteShortUrl(id);
            return ResponseEntity.ok().build();

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public String home() {
        return "Application mini api!";
    }

    @GetMapping("{shortUrl}")
    public ResponseEntity<?> redirect(@PathVariable(value = "shortUrl") @NotNull String shortUrl) {
        try {
            String url = shortUrlService.getFullUrl(shortUrl);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
