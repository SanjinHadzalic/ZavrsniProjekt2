package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CircumstancesPresumed {
    _0("No doubt about the circumstances"),
    _1("Circumstances presumed");

    private final String description;
}
