package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

/**
 * On the ringing encounter, always code this field as: 0 – Ring not verified by the scheme.
 * Ring verification may be by the ring being sent or a photograph, photocopy, rubbing or carbon copy being
 * available. Records should also be marked as verified if the ring has been seen by the ringing scheme but
 * subsequently returned to the finder.
 */

@Entity
@Table(name = "verification_of_the_metal_ring")
@Data
public class VerificationOfTheMetalRing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
