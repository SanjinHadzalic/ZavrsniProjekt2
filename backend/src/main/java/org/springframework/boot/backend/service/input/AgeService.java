package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.Age;

import java.util.List;
import java.util.Optional;

public interface AgeService {
    List<Age> getAllAges();
    Optional<Age> getAgeById(Long id);
}
