package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MetalRingInformation {
    _0("Metal ring is not present"),
    _1("Metal ring added (where no metal ring was present), position (on tarsus or above) unknown or unrecorded"),
    _2("Metal ring added (where no metal ring was present), definitely on tarsus"),
    _3("Metal ring added (where no metal ring was present), definitely above tarsus"),
    _4("Metal ring is already present"),
    _5("Metal ring changed"),
    _6("Metal ring removed and bird released alive (use code 4 if bird was dead)"),
    _7("Metal ring added, where a metal ring was already present");

    private final String description;
}
