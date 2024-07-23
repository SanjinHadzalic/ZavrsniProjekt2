package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.AccuracyOfDate;
import org.springframework.boot.backend.repository.input.AccuracyOfDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccuracyOfDateServiceImpl implements AccuracyOfDateService{
    private AccuracyOfDateRepository accuracyOfDateRepository;
    @Override
    public List<AccuracyOfDate> getAllAccuracyOfDates() {
        return accuracyOfDateRepository.findAll();
    }

    @Override
    public Optional<AccuracyOfDate> getAccuracyOfDateById(Long id) {
        return accuracyOfDateRepository.findById(id);
    }
}
