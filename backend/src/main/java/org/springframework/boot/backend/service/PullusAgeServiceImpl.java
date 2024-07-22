package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.PullusAge;
import org.springframework.boot.backend.repository.PullusAgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PullusAgeServiceImpl implements PullusAgeService{
    private PullusAgeRepository pullusAgeRepository;
    @Override
    public List<PullusAge> getAllPullusAges() {
        return pullusAgeRepository.findAll();
    }

    @Override
    public Optional<PullusAge> getPullusAgeById(Long id) {
        return pullusAgeRepository.findById(id);
    }
}
