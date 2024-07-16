package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.RingingScheme;
import org.springframework.boot.backend.repository.RingingSchemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RingingSchemeServiceImpl implements RingingSchemeService{
    private RingingSchemeRepository ringingSchemeRepository;
    @Override
    public List<RingingScheme> getAllRingingSchemes() {
        return ringingSchemeRepository.findAll();
    }

    @Override
    public Optional<RingingScheme> getRingingSchemeById(Long id) {
        return ringingSchemeRepository.findById(id);
    }
}
