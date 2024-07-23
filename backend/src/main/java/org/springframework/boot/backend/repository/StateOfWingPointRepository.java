package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.StateOfWingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateOfWingPointRepository extends JpaRepository<StateOfWingPoint, Long> {
}
