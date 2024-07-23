package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.CircumstancesPresumed;

import java.util.List;
import java.util.Optional;

public interface CircumstancesPresumedService {
    List<CircumstancesPresumed> getAllCircumstancesPresumed();
    Optional<CircumstancesPresumed> getCircumstancesPresumedById(Long id);
}
