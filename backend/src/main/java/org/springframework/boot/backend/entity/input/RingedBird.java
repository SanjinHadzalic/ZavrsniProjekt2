package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ringed_bird")
@Data
public class RingedBird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
