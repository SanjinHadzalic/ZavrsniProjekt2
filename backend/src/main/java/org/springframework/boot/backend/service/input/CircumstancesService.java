package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.Circumstances;

import java.util.List;
import java.util.Optional;

public interface CircumstancesService {
    List<Circumstances> getAllCircumstances();
    Optional<Circumstances> getCircumstancesById(Long id);
}
