package com.gmail.alf.miniapi.services;

import com.gmail.alf.miniapi.entities.ShortUrl;
import com.gmail.alf.miniapi.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * The service for managing short url.
 */
public interface ShortUrlService {

    /**
     * Get all ShortUrl existing in database.
     * Potential improvement : Paging the list of urls
     * @return the list of existing urls
     */
    List<ShortUrl> findAllShortUrls();

    /**
     * Find a ShortUrl by is id.
     *
     * @param id the ShortUrl id to find
     * @return the ShortUrl found
     * @throws ResourceNotFoundException if no ShortUrl has been found
     */
    ShortUrl findShortUrlById(long id) throws ResourceNotFoundException;

    /**
     * Find a bean
     * @param id the ShortUrl id to found
     * @return the ShortUrl found
     * @throws ResourceNotFoundException if no ShortUrl has been found
     */
    String getFullUrl(String id) throws ResourceNotFoundException;

    /**
     * Create a ShortUrl
     * @param shortURL contains only the url to manage
     * @return the ShortUrl with id and generated short url
     */
    ShortUrl createShortUrl(ShortUrl shortURL);

    /**
     * Update an existing ShortUrl
     * @param id the ShortUrl id to update
     * @param shortURL contain the new values for the ShortUrl
     * @return the updated ShortUrl
     * @throws ResourceNotFoundException if no ShortUrl has been found
     */
    ShortUrl updateShortUrl(long id, ShortUrl shortURL) throws ResourceNotFoundException;

    /**
     * Delete a ShortUrl with is id
     * @param id the id of the ShortUrl to delete
     * @throws ResourceNotFoundException if no ShortUrl has been found
     */
    void deleteShortUrl(Long id) throws ResourceNotFoundException;
}
