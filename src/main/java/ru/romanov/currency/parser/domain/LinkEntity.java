package ru.romanov.currency.parser.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "link")
@DynamicUpdate
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "inner_link")
    private String srcLink;
    @Column(name = "outer_link")
    private String outLink;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
