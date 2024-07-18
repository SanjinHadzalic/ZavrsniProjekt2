package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The options are presented in order with the most important first.
 *
 * Code R to be used where ringing has caused injury to the bird and code P where the bird was already in
 * poor condition when it was caught. Note that accidental loss of more than half the rectrices should cause
 * theses codes to be used but not if the loss was during the normal course of the bird's moult
 */

@Getter
@AllArgsConstructor
public enum Manipulated {
    H("Hand reared"),
    K("Fledgling provoked"),
    C("Captive for more than 24 hours (code date of release)"),
    F("Transported (more than 10 km) from co-ordinates coded"),
    T("Transported (more than 10 km) to co-ordinates coded"),
    M("Manipulated (injection, biopsy, radio- or satellite telemetry etc.)"),
    R("Ringing accident"),
    E("Euthanized; bird humanely destroyed (reasons will be explained in Circumstances)"),
    P("Poor condition when caught"),
    N("Normal, not manipulated bird"),
    U("Uncoded or unknown if manipulated or not");

    private final String description;
}
