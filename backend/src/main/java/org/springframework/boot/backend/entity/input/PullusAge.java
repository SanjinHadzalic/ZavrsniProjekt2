package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pullus_age")
@Data
public class PullusAge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
