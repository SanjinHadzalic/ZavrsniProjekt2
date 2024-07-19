package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccuracyOfCoordinates {
    _0("Accurate to the given coordinates (somewhere in a circle with radius 1 km)"),
    _1("Somewhere in a circle with radius 5 km"),
    _2("Somewhere in a circle with radius 10 km "),
    _3("Somewhere in a circle with radius 20 km"),
    _4("Somewhere in a circle with radius 50 km"),
    _5("Somewhere in a circle with radius 100 km"),
    _6("Somewhere in a circle with radius 500 km"),
    _7("Somewhere in a circle with radius 1000 km"),
    _8("Reserved"),
    _9("Somewhere in the country or region given in the field Place Code");

    private final String description;
}
