package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bill_method")
@Data
public class BillMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String language;
    private String description;}