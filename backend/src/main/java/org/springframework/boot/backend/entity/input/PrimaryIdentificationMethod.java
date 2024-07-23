package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

/**
 * This field is to denote the primary method used to identify a bird. Where a metal ring is present, this
 * will always be the primary identification method, regardless of what other marks are placed on
 * the bird. With the development of new technology it is likely that, in the future, some birds may be marked
 * by other methods (e.g. transponders) and will not have metal rings attached. This field anticipates that
 * future need. At present, the primary identification marker will almost invariably be a metal ring.
 */

@Entity
@Table(name = "primary_identification_method")
@Data
public class PrimaryIdentificationMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
