package ru.romanov.currency.parser.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.romanov.currency.parser.service.LinkSearcherService;

@Controller
public class RedirectController {

    private final LinkSearcherService linkSearcherService;

    @Autowired
    public RedirectController(LinkSearcherService linkSearcherService) {
        this.linkSearcherService = linkSearcherService;
    }

    @GetMapping("/{link}")
    public String redirect(@PathVariable String link, HttpServletRequest request) {
        String srcLink = linkSearcherService.searchLink(link);
        return "redirect:" + request.getScheme() + "://" + srcLink;
    }
}
