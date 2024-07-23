package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

/**
 * All full-grown birds must have a Status code, even if it is the unknown/not recorded code, U. Birds ringed as
 * pulli must be coded with a hyphen. These codes are in order of priority. Thus if a wintering Blackbird is caught
 * at a roost, the Status code will be R, not W. Likewise a moulting bird which is also nesting should have the
 * status code N.
 * These codes are listed in descending order of priority
 */

@Entity
@Table(name = "status")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
