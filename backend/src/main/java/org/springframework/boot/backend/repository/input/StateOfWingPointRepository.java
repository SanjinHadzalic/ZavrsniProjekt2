package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.StateOfWingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateOfWingPointRepository extends JpaRepository<StateOfWingPoint, Long> {
}
