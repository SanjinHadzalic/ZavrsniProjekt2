package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All full-grown birds must have a Status code, even if it is the unknown/not recorded code, U. Birds ringed as
 * pulli must be coded with a hyphen. These codes are in order of priority. Thus if a wintering Blackbird is caught
 * at a roost, the Status code will be R, not W. Likewise a moulting bird which is also nesting should have the
 * status code N.
 * These codes are listed in descending order of priority
 */

@Getter
@AllArgsConstructor
public enum Status {
    _x("bird a pullus"),
    U("Unknown or unrecorded"),
    N("Nesting or Breeding"),
    R("Roosting assemblage"),
    K("In Colony (not necessarily breeding but not pullus)"),
    M("Moulting assemblage (whether bird moulting or not)"),
    T("moulting"),
    L("Apparently a local bird, but not breeding"),
    W("Apparently a bird wintering in the locality"),
    P("On Passage"),
    S("At Sea");

    private final String description;
}
