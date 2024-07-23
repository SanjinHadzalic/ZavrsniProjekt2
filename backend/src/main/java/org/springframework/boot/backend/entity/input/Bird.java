package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bird")
@Data
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "common_name")
    private String commonName;
    @Column(name = "scientific_name")
    private String scientificName;
    private String aerc;
    private String status;
    private String season;
    private Integer euringBirdCode;
}
