package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.PectoralMuscleScore;
import org.springframework.boot.backend.repository.PectoralMuscleScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PectoralMuscleScoreServiceImpl implements PectoralMuscleScoreService{

    private PectoralMuscleScoreRepository pectoralMuscleScoreRepository;

    @Override
    public List<PectoralMuscleScore> getAllPectoralMuscleScores() {
        return pectoralMuscleScoreRepository.findAll();
    }

    @Override
    public Optional<PectoralMuscleScore> getPectoralMuscleScoreById(Long id) {
        return pectoralMuscleScoreRepository.findById(id);
    }
}
