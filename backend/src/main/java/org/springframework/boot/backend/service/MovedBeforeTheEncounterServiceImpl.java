package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.MovedBeforeTheEncounter;
import org.springframework.boot.backend.repository.MovedBeforeTheEncounterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovedBeforeTheEncounterServiceImpl implements MovedBeforeTheEncounterService{
    private MovedBeforeTheEncounterRepository movedBeforeTheEncounterRepository;
    @Override
    public List<MovedBeforeTheEncounter> getAllMovedBeforeTheEncounter() {
        return movedBeforeTheEncounterRepository.findAll();
    }

    @Override
    public Optional<MovedBeforeTheEncounter> getMovedBeforeTheEncounterById(Long id) {
        return movedBeforeTheEncounterRepository.findById(id);
    }
}
