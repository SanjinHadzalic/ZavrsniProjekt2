package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.AccuracyOfCoordinates;
import org.springframework.boot.backend.repository.AccuracyOfCoordinatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccuracyOfCoordinatesServiceImpl implements AccuracyOfCoordinatesService{
    private AccuracyOfCoordinatesRepository accuracyOfCoordinatesRepository;
    @Override
    public List<AccuracyOfCoordinates> getAllAccuracyOfCoordinates() {
        return accuracyOfCoordinatesRepository.findAll();
    }

    @Override
    public Optional<AccuracyOfCoordinates> getAccuracyOfCoordinatesById(Long id) {
        return accuracyOfCoordinatesRepository.findById(id);
    }
}
