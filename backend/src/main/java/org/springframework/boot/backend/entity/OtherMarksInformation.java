package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This gives information about any other marks associated with the bird. There are five 2-letter codes which are
 * special cases (although most encounter records will have the special case ZZ – no marks other than metal
 * ring.) For all other codes, the first character gives the type of mark and the second gives the state of this
 * marking.
 */

@Getter
@AllArgsConstructor
public enum OtherMarksInformation {
    //  First character
        // Permanent marks
    B("Coloured or numbered leg-ring(s) or flags"),
    C("Coloured or numbered neck-ring(s)"),
    D("Coloured or numbered wing tag(s)"),
    E("Radio-tracking device"),
    F("Satellite-tracking device"),
    G("Transponder"),
    H("Nasal mark(s)"),
    K("GPS logger"),
    L("Geolocator logger (recording daylight)"),

        // Temporary marks
    R("Flight feathers stamped with the ring number"),
    S("Tape on the ring"),
    T("Dye mark (some part of plumage dyed, painted or bleached)");

    //  Second character
    //TODO -> dodati sve kombinacije slova prisutne u staroj aplikaciji

    private final String description;
}
