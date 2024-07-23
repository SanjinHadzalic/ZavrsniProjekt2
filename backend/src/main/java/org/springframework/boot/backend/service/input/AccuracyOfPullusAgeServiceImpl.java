package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.AccuracyOfPullusAge;
import org.springframework.boot.backend.repository.input.AccuracyOfPullusAgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccuracyOfPullusAgeServiceImpl implements AccuracyOfPullusAgeService{
    private AccuracyOfPullusAgeRepository accuracyOfPullusAgeRepository;
    @Override
    public List<AccuracyOfPullusAge> getAllAccuracyOfPullusAges() {
        return accuracyOfPullusAgeRepository.findAll();
    }

    @Override
    public Optional<AccuracyOfPullusAge> getAccuracyOfPullusAgeById(Long id) {
        return accuracyOfPullusAgeRepository.findById(id);
    }
}
