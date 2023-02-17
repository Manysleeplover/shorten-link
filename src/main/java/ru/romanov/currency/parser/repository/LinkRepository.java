package ru.romanov.currency.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.romanov.currency.parser.domain.LinkEntity;

public interface LinkRepository extends JpaRepository<LinkEntity, Long> {

    @Query(value = "select * from link where link.outer_link = :link", nativeQuery = true)
    LinkEntity findLink(@Param("link") String link);
}
