package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BillMethod {
    C("From tip to Cere"),
    F("From tip to Feathers"),
    N("From tip to Nostril"),
    S("From tip to Skull");

    private final String description;
}
