package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

/**
 *  Codes are defined for three methods of assessing fat – the BTO Biometrics Working Group, ESF and Operation
 *  Baltic. If a fat score is given, then the relevant code must be given in Fat Score Method.
 */

@Entity
@Table(name = "fat_score")
@Data
public class FatScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String score;
    private String language;
    private String description;
}
