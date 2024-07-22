package org.springframework.boot.backend.repository;


import org.springframework.boot.backend.entity.MovedBeforeTheEncounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovedBeforeTheEncounterRepository extends JpaRepository<MovedBeforeTheEncounter, Long> {
}
