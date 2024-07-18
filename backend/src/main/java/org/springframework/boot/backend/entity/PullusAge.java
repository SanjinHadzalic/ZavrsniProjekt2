package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PullusAge {
    _x("Bird is not a pullus"),
    _99("Pullus age not recorded"),
    _00("Pullus age 0 days"),
    _01("Pullus age 1 day"); //TODO -> dodati jos dana

    private final String description;
}
