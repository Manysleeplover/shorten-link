package ru.romanov.currency.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanov.currency.parser.domain.LinkEntity;
import ru.romanov.currency.parser.repository.LinkRepository;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ShortenerService {

    private LinkRepository linkRepository;

    @Autowired
    public ShortenerService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String processLink(String link) {
        String shortLink = generateCharSequence(link);
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setSrcLink(link);
        linkEntity.setOutLink(shortLink);
        linkEntity.setCreatedAt(LocalDateTime.now());
        linkRepository.save(linkEntity);
        return shortLink;
    }

    private String generateCharSequence(String link) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        return generatedString;
    }
}
