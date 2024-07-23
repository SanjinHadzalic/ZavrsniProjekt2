package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "euring_code_identifier")
@Data
public class EURINGCodeIdentifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
