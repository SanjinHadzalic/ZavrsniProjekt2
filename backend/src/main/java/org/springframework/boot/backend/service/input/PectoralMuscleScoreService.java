package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.PectoralMuscleScore;

import java.util.List;
import java.util.Optional;

public interface PectoralMuscleScoreService {
    List<PectoralMuscleScore> getAllPectoralMuscleScores();
    Optional<PectoralMuscleScore> getPectoralMuscleScoreById(Long id);
}
