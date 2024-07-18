package org.springframework.boot.backend.entity;

import lombok.Getter;

/**
 * On the ringing encounter, always code this field as: 0 – Ring not verified by the scheme.
 * Ring verification may be by the ring being sent or a photograph, photocopy, rubbing or carbon copy being
 * available. Records should also be marked as verified if the ring has been seen by the ringing scheme but
 * subsequently returned to the finder.
 */

@Getter
public enum VerificationOfTheMetalRing {
    _0("Ring not verified by scheme"),
    _1("Ring verified by scheme"),
    _9("Unknown if ring verified by scheme");

    private final String description;

    VerificationOfTheMetalRing(String description) {
        this.description = description;
    }
}
