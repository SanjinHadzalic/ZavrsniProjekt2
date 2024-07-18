package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sex {
    U("Unknown"),
    M("Male"),
    F("Female");

    private final String description;
}
