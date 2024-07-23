package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.FatScore;

import java.util.List;
import java.util.Optional;

public interface FatScoreService {
    List<FatScore> getAllFatScores();
    Optional<FatScore> getFatScore(Long id);
}
