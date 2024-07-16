package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ringingScheme")
public class RingingScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String country;
    private String centre;
    private Boolean euring;
    private Boolean current;
    private LocalDate dateUpdated;
    private String notes;
}
