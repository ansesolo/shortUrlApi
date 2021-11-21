package com.gmail.alf.miniapi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The entity declaration for persistence.
 * Potential improvement :
 *      manage unique constraint on attribute url.
 *      We can adopt another strategy for the id.
 */
@Entity
@Table(name = "short_urls")
public class ShortUrl implements CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 255)
    private String shortUrl;

    @Size(max = 255)
    @NotNull
    private String url;

    public ShortUrl() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(final String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ShortUrl{" + "id=" + id + ", shortUrl='" + shortUrl + '\'' + ", url='" + url + '\'' + '}';
    }
}


