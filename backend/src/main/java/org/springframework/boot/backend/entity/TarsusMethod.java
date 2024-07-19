package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TarsusMethod {
    M("Maximum tarsus - folded foot to extreme end of tarsal joint"),
    S("Minimum tarsus - length of tarso-metatarsal bone"),
    T("Tarsus and toe - from extreme end of tarsal joint to tip of longest toe with foot flattened on a rule");

    private final String description;
}
