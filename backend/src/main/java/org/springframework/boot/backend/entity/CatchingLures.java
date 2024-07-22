package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "catching_lures")
@Data
public class CatchingLures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
