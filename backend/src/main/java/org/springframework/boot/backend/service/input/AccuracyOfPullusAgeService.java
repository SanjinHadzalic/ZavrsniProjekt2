package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.AccuracyOfPullusAge;

import java.util.List;
import java.util.Optional;

public interface AccuracyOfPullusAgeService {
    List<AccuracyOfPullusAge> getAllAccuracyOfPullusAges();
    Optional<AccuracyOfPullusAge> getAccuracyOfPullusAgeById(Long id);
}
