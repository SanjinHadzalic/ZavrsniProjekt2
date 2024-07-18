package org.springframework.boot.backend.entity;

import lombok.Getter;

/**
 * This field is to denote the primary method used to identify a bird. Where a metal ring is present, this
 * will always be the primary identification method, regardless of what other marks are placed on
 * the bird. With the development of new technology it is likely that, in the future, some birds may be marked
 * by other methods (e.g. transponders) and will not have metal rings attached. This field anticipates that
 * future need. At present, the primary identification marker will almost invariably be a metal ring.
 */

@Getter
public enum PrimaryIdentificationNumber {
    A0("Metal ring"),
    B0("Coloured or numbered leg ring(s)"),
    C0("Coloured or numbered neck ring(s)"),
    D0("Wing Tags"),
    E0("Radio tracking device"),
    F0("Satellite tracking device"),
    G0("Transponder"),
    H0("Nasal mark(s)"),
    K0("GPS loggers"),
    L0("Geolocator loggers (recording daylight)"),
    R0("Flight feather(s) stamped with a number"),
    T0("Body or wing painting or bleaching");

    private final String description;

    PrimaryIdentificationNumber(String description){
        this.description = description;
    }
}
