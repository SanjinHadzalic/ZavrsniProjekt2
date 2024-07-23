package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Circumstances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircumstancesRepository extends JpaRepository<Circumstances, Long> {
}
