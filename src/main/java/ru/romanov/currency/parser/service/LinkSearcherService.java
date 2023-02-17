package ru.romanov.currency.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanov.currency.parser.domain.LinkEntity;
import ru.romanov.currency.parser.repository.LinkRepository;

@Service
public class LinkSearcherService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkSearcherService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String searchLink(String link){
        LinkEntity linkEntity = linkRepository.findLink(link);
        System.out.println(linkEntity.getSrcLink());
        return linkEntity.getSrcLink();
    }
}
