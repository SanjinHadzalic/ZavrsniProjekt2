package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccuracyOfPullusAge {
    _x("Bird is not a pullus"),
    _0("Accurate to the day"),
    _1("Accurate to within 1 day either side of day coded"),
    _2("Accurate to within 2 days either side of day coded"),
    _3("Accurate to within 3 days either side of day coded"),
    _4("Accurate to within 4 days either side of day coded"),
    _5("Accurate to within 5 days either side of day coded"),
    _6("Accurate to within 6 days either side of day coded"),
    _7("Accurate to within 7 days either side of day coded"),
    _8("Accurate to within 8 days either side of day coded"),
    _9("Accurate to within 9 days either side of day coded"),
    U("Unrecorded/not known");

    private final String description;
}
