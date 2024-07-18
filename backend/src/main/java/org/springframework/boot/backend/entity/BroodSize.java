package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The biologically important information is the number of young alive at the time of ringing, regardless whether
 * they were already ringed, were ringed at that time, or not ringed at all.
 * Note the two 'unknown' codes 00 and 99 apply to broods from one and more than one female respectively
 */

@Getter
@AllArgsConstructor
public enum BroodSize {
    _x("Bird is not a testling"),
    _00("Unknown or not coded"),
    _01("1 chick in the nest"),
    _02("2 chicks in the nest"),
    _03("3 chicks in the nest"),
    _04("4 chicks in the nest");

    private final String description;
}
