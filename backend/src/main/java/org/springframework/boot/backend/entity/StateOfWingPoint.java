package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "state_of_wing_point")
@Data
public class StateOfWingPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
