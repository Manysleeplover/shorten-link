package ru.romanov.currency.parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.romanov.currency.parser.service.ShortenerService;

@Controller
public class ShortenerController {

    @Autowired
    private ShortenerService shortenerService;

    @GetMapping("/")
    public String shortenLink(@RequestParam(name = "link") String link) {
        System.out.println(shortenerService.shorten() + link);
        return "link";
    }
}
