package org.springframework.boot.backend.entity;

import lombok.Getter;

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
