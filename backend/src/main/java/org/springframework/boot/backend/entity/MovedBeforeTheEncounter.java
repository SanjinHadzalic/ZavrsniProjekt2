package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The movement indicated by these codes is that which has happened before the encounter has been reported
 * and indicates that the bird may have last been alive in the wild state at some place other than the capture /
 * recapture / recovery locality coded.
 */

@Getter
@AllArgsConstructor
public enum MovedBeforeTheEncounter {
    _0("Not moved"),
    _2("Moved unintentionally by man or other agency"),
    _4("Moved intentionally by man"),
    _6("Moved by water (e.g. found on shoreline)"),
    _9("Uncoded or unknown if moved or not");

    private final String description;
}
