package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.StateOfWingPoint;

import java.util.List;
import java.util.Optional;

public interface StateOfWingPointService {
    List<StateOfWingPoint> getAllStateOfWingPoint();
    Optional<StateOfWingPoint> getStateOfWingPointById(Long id);
}
