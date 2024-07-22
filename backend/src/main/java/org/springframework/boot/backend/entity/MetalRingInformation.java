package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 *  N.b. within EURING there is an
 * explicit agreement that ringers must not add a metal ring when one is already present (except in
 * circumstances where the existing ring needs to be replaced because of wear).
 */

@Entity
@Table(name = "metal_ring_information")
@Data
public class MetalRingInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
