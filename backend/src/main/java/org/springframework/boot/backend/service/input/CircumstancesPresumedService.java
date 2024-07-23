package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.CircumstancesPresumed;

import java.util.List;
import java.util.Optional;

public interface CircumstancesPresumedService {
    List<CircumstancesPresumed> getAllCircumstancesPresumed();
    Optional<CircumstancesPresumed> getCircumstancesPresumedById(Long id);
}
