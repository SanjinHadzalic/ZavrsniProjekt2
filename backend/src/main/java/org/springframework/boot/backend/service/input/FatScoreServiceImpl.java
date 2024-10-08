package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.FatScore;
import org.springframework.boot.backend.repository.input.FatScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FatScoreServiceImpl implements FatScoreService{

    private FatScoreRepository fatScoreRepository;

    @Override
    public List<FatScore> getAllFatScores() {
        return fatScoreRepository.findAll();
    }

    @Override
    public Optional<FatScore> getFatScore(Long id) {
        return fatScoreRepository.findById(id);
    }
}
