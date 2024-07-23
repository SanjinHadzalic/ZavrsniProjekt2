package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.StateOfWingPoint;

import java.util.List;
import java.util.Optional;

public interface StateOfWingPointService {
    List<StateOfWingPoint> getAllStateOfWingPoint();
    Optional<StateOfWingPoint> getStateOfWingPointById(Long id);
}
