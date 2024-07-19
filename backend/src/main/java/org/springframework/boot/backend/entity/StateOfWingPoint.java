package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateOfWingPoint {
    U("Unknown or not recorded"),
    A("Abraded"),
    B("Broken"),
    G("Growing"),
    M("Feather Missing"),
    V("Very Abraded");

    private final String description;
}
