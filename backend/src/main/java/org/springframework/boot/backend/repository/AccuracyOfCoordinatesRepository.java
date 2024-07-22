package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.AccuracyOfCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccuracyOfCoordinatesRepository extends JpaRepository<AccuracyOfCoordinates, Long> {
}
