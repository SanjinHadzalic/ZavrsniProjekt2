package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sexing_method")
@Data
public class SexingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
