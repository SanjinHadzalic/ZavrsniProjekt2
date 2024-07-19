package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EURINGCodeIdentifier {
    _0("EURING Code Manual (1966). Directly coded (no translation)"),
    _1("Code Manual New EURING (1979), but translated from EURING Code Manual (1966)"),
    _2("Code Manual New EURING (1979). Directly coded (no translation of older codes)"),
    _3("Translated from earlier code but exact route uncertain"),
    _4("EURING exchange-code 2000 or 2000+. Directly coded (no translation of older codes)"),
    _5("Direct translation from 2000 or 2000+ code. Note that older records with identifiers 1, 2, 3 will " +
            "still hold the same identification code when they are further translated to 2020 code"),
    _6("EURING exchange-code 2020. Directly coded (no translation of older codes)");

    private final String description;
}
