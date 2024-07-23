package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.PullusAge;
import org.springframework.boot.backend.repository.input.PullusAgeRepository;
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
