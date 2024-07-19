package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Moult {
    B("active Body and/or covert moult not as part of post-juvenile or main moult"),
    J("wholly Juvenile plumage"),
    M("active moult which includes flight feathers (primary and/or secondaries)"),
    P("partial post-juvenile moult which does not include flight feathers"),
    X("Examined for moult, no moult found and not in juvenile plumage"),
    U("Unknown, not examined for moult or not recorded");

    private final String description;
}
