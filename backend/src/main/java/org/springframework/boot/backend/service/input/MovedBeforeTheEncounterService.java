package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.MovedBeforeTheEncounter;

import java.util.List;
import java.util.Optional;

public interface MovedBeforeTheEncounterService {
    List<MovedBeforeTheEncounter> getAllMovedBeforeTheEncounter();
    Optional<MovedBeforeTheEncounter> getMovedBeforeTheEncounterById(Long id);
}
