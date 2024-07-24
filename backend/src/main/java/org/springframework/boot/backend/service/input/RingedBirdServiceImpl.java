package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.repository.input.RingedBirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RingedBirdServiceImpl implements RingedBirdService{
    private RingedBirdRepository ringedBirdRepository;
    @Override
    public List<RingedBird> getAllRingedBird() {
        return ringedBirdRepository.findAll();
    }

    @Override
    public Optional<RingedBird> getRingedBirdById(Long id) {
        return ringedBirdRepository.findById(id);
    }
}
