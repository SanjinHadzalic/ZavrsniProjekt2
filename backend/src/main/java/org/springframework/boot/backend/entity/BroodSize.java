package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The biologically important information is the number of young alive at the time of ringing, regardless whether
 * they were already ringed, were ringed at that time, or not ringed at all.
 * Note the two 'unknown' codes 00 and 99 apply to broods from one and more than one female respectively
 */

@Entity
@Table(name = "brood_size")
@Data
public class BroodSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
