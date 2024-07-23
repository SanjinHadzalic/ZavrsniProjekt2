package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.Age;
import org.springframework.boot.backend.repository.input.AgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AgeServiceImpl implements AgeService{
    private AgeRepository ageRepository;

    @Override
    public List<Age> getAllAges() {
        return ageRepository.findAll();
    }

    @Override
    public Optional<Age> getAgeById(Long id) {
        return ageRepository.findById(id);
    }
}
