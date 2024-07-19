package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Circumstances {
    _0("Unknown circumstances or unknown whether through man's agency or naturally"),
    _1("Intentionally by man -shot"),
    _2("Intentionally by man - other means and recaptures"),
    _3("Accidentally by man - pollution"),
    _4("Accidentally through human agency (not pollution)"),
    _5("Natural causes - diseases and other natural ailments"),
    _6("Predation by any animal other than man"),
    _7("Other natural causes. Drowned, trapped, tangled and collided with natural objects and also weather" +
            " and starvation or thirst"),
    _8("Bird identified from something else than the metal ring"),
    _9("Other special circumstances"),
    _99("Totally unknown circumstance: not even stated to be found");

    private final String description;
}
