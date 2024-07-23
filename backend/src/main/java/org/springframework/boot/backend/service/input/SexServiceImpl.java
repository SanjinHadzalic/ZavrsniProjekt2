package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.Sex;
import org.springframework.boot.backend.repository.input.SexRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SexServiceImpl implements SexService {
    private SexRepository sexRepository;
    @Override
    public List<Sex> getAllSexes() {
        return sexRepository.findAll();
    }

    @Override
    public Optional<Sex> findSexById(Long id) {
        return sexRepository.findById(id);
    }
}
