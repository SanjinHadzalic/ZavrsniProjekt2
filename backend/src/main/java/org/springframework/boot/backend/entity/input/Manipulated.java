package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The options are presented in order with the most important first.
 *
 * Code R to be used where ringing has caused injury to the bird and code P where the bird was already in
 * poor condition when it was caught. Note that accidental loss of more than half the rectrices should cause
 * theses codes to be used but not if the loss was during the normal course of the bird's moult
 */

@Entity
@Table(name = "manipulated")
@Data
public class Manipulated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
