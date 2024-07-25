package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "place")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String regionCode;
    private Double latitude;
    private Double longitude;
    @ManyToOne
    @JoinColumn(name = "precision_id")
    private AccuracyOfCoordinates precision;
    private String notes;
}
