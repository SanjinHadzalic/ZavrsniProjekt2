package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Condition {
    _0("Condition completely unknown"),
    _1("Dead but no information on how recently the bird had died (or been killed)"),
    _2("Freshly dead - within about a week"),
    _3("Not freshly dead"),
    _4("Found sick, wounded, unhealthy etc. and known to have been released"),
    _5("Found sick, wounded, unhealthy etc. and not released or not known if released"),
    _6("Alive and probably healthy but taken into captivity"),
    _7("Alive and probably healthy and certainly released"),
    _8("Alive and probably healthy and released by a ringer"),
    _9("Alive and probably healthy but ultimate fate of bird ");

    private final String description;
}
