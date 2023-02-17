package ru.romanov.currency.parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.romanov.currency.parser.service.LinkSearcherService;
import ru.romanov.currency.parser.service.ShortenerService;

@RestController("/")
public class ShortenerController {

    private final ShortenerService shortenerService;

    @Autowired
    public ShortenerController(ShortenerService shortenerService, LinkSearcherService linkSearcherService) {
        this.shortenerService = shortenerService;
    }

    @GetMapping("get/{link}")
    public String getLink(@PathVariable String link) {
        return "localhost:8080/" + shortenerService.processLink(link);
    }

}