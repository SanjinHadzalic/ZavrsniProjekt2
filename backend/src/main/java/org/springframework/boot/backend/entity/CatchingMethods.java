package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CatchingMethods {
    _x("not applicable, because there was no catching at all"), //TODO -> zapravo je crtica "-"
    A("Actively triggered a trap (by ringer)"),
    B("trap automatically triggered by bird"),
    C("Cannon net or rocket net"),
    D("Dazzling"),
    F("Caught in flight by anything other than a static mist net"),
    G("Nets put just under the water's surface and lifted up as waterfowl (ducks, grebes, divers) swim over it"),
    H("By hand"),
    L("clap net"),
    M("mist net"),
    N("on nest (any method). Not applicable to nestlings which are still in the nest"),
    O("Any other system"),
    P("Phuh net"),
    R("Round up whilst flightless"),
    S("Bal-chatri or other snare device"),
    T("Helgoland trap or duck decoy"),
    U("Dutch net for Pluvialis apricaria"),
    V("Roosting in cavity"),
    W("Passive Walk-in / maze trap"),
    Z("unknown");

    private final String description;
}
