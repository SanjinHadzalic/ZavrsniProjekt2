package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.AccuracyOfCoordinates;

import java.util.List;
import java.util.Optional;

public interface AccuracyOfCoordinatesService {
    List<AccuracyOfCoordinates> getAllAccuracyOfCoordinates();
    Optional<AccuracyOfCoordinates> getAccuracyOfCoordinatesById(Long id);
}
