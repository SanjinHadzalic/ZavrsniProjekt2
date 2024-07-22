package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accuracy_of_date")
@Data
public class AccuracyOfDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
