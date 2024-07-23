package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.AccuracyOfCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccuracyOfCoordinatesRepository extends JpaRepository<AccuracyOfCoordinates, Long> {
}
