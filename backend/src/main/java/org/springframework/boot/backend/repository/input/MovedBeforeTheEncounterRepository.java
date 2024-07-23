package org.springframework.boot.backend.repository.input;


import org.springframework.boot.backend.entity.input.MovedBeforeTheEncounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovedBeforeTheEncounterRepository extends JpaRepository<MovedBeforeTheEncounter, Long> {
}
