package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.AccuracyOfDate;
import org.springframework.boot.backend.repository.AccuracyOfDateRepository;
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
