package org.springframework.boot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Age {
    _0("Age uknown"),
    _1("Pullus"),
    _2("Full-grown"),
    _3("First-year"),
    _4("After first-year"),
    _5("Second year"),
    _6("After second year"),
    _7("Third year"),
    _8("After third year"),
    _9("Fourth year"),
    A("After fourth year"),
    B("Fifth year");

    private final String description;
}
