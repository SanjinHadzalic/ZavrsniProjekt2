package org.springframework.boot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * This gives information about any other marks associated with the bird. There are five 2-letter codes which are
 * special cases (although most encounter records will have the special case ZZ – no marks other than metal
 * ring.) For all other codes, the first character gives the type of mark and the second gives the state of this
 * marking.
 */
@Entity
@Table(name = "other_marks_information")
@Data
public class OtherMarksInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;
}
