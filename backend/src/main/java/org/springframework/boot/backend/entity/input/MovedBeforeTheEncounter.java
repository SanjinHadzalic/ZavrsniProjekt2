package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The movement indicated by these codes is that which has happened before the encounter has been reported
 * and indicates that the bird may have last been alive in the wild state at some place other than the capture /
 * recapture / recovery locality coded.
 */
@Entity
@Table(name = "moved_before_the_encounter")
@Data
public class MovedBeforeTheEncounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;

}
