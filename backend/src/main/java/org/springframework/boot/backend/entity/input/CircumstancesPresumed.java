package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "circumstances_presumed")
@Data
public class CircumstancesPresumed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
