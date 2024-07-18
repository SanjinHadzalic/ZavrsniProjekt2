package org.springframework.boot.backend.entity;

import lombok.Getter;

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
