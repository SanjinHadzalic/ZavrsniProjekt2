package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlumageCode {
    //  Alphabetic codes for any species
    U("Unknown or not recorded"),
    A("Adult plumage (if no other codes applicable)"),
    B("Breeding plumage - where species have a distinct breeding plumage"),
    D("Downy - for nestlings and nidifugous chicks"),
    E("Eclipse plumage (ducks)"),
    F("First winter (typically corresponding to EURING age codes 3 or 5)"),
    I("Immature (expect for first winter plumage)"),
    J("Juvenile"),
    W("Winter plumage - where species have a distinct winter plumage"),

    //  Numeric codes for waders only
    _1("Full winter plumage"),
    _2("Trace of summer plumage"),
    _3("1/4 summer plumage"),
    _4("1/2 summer plumage"),
    _5("3/4 summer plumage"),
    _6("Trace of winter plumage"),
    _7("Full summer plumage");

    private final String description;
}
