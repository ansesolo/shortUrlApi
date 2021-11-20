package com.gmail.alf.miniapi.controllers;

import com.gmail.alf.miniapi.entities.ShortUrl;
import com.gmail.alf.miniapi.exceptions.ResourceNotFoundException;
import com.gmail.alf.miniapi.services.ShortUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    private ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("api/v1/short_url")
    public List<ShortUrl> findAllShortURLs() {
        return shortUrlService.findAllShortURLs();
    }

    @GetMapping("api/v1/short_url/{id}")
    public ResponseEntity<ShortUrl> findShortURLById(@PathVariable(value = "id") long id) {
        try {
            ShortUrl shortUrl = shortUrlService.findShortURLById(id);
            return ResponseEntity.ok().body(shortUrl);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("api/v1/short_url")
    public ResponseEntity<ShortUrl> createShortUrl(@RequestBody ShortUrl shortURL) {
        return new ResponseEntity<>(shortUrlService.createShortUrl(shortURL), HttpStatus.CREATED);
    }

    @PutMapping("api/v1/short_url/{id}")
    public ResponseEntity<ShortUrl> updateShortUrl(@PathVariable(value = "id") long id, @RequestBody ShortUrl shortURL) {
        try {
            ShortUrl updatedShortUrl = shortUrlService.updateShortUrl(id, shortURL);
            return ResponseEntity.ok().body(updatedShortUrl);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
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
        return "Application mini api! \n Use api/v1/short_url";
    }
}
