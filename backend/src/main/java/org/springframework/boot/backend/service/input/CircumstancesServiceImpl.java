package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.Circumstances;
import org.springframework.boot.backend.repository.input.CircumstancesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CircumstancesServiceImpl implements CircumstancesService{
    private CircumstancesRepository circumstancesRepository;
    @Override
    public List<Circumstances> getAllCircumstances() {
        return circumstancesRepository.findAll();
    }

    @Override
    public Optional<Circumstances> getCircumstancesById(Long id) {
        return circumstancesRepository.findById(id);
    }
}
