package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccuracyOfDate {
    _0("Accurate to the day"),
    _1("Accurate to within 1 day either side of date coded"),
    _2("Accurate to within 3 days either side of date coded"),
    _3("Accurate to within 1 week either side of date coded"),
    _4("Accurate to within 2 weeks either side of date coded"),
    _5("Accurate to within 6 weeks either side of date coded"),
    _6("Accurate to within 3 months either side of date coded"),
    _7("Accurate to within 6 months either side of date coded"),
    _8("Accurate to within some years only"),
    _9("Date of issue of ring or other earliest possible use of ring");

    private final String description;


}
