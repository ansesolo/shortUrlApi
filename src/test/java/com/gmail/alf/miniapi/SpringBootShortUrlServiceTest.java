package com.gmail.alf.miniapi;

import com.gmail.alf.miniapi.entities.ShortUrl;
import com.gmail.alf.miniapi.services.ShortUrlService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringBootShortUrlServiceTest {

    @Autowired
    private ShortUrlService shortUrlService;

    @Test
    @Order(1)
    public void should_find_all_shortUrls() {

        List<ShortUrl> shortUrls = shortUrlService.findAllShortUrls();

        Assertions.assertEquals(shortUrls.size(), 2);
    }

    @Test
    @Order(2)
    public void should_generate_correct_shortUrl() {
        ShortUrl shortURL = new ShortUrl();
        shortURL.setUrl("http://leprogres.com/abcdef");

        ShortUrl newSortUrl = shortUrlService.createShortUrl(shortURL);

        Assertions.assertEquals(newSortUrl.getShortUrl(), String.valueOf(shortURL.getUrl().hashCode()));
    }

}
