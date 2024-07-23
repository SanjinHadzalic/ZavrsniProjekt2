package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.CircumstancesPresumed;
import org.springframework.boot.backend.repository.CircumstancesPresumedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CircumstancesPresumedServiceImpl implements CircumstancesPresumedService{
    private CircumstancesPresumedRepository circumstancesPresumedRepository;
    @Override
    public List<CircumstancesPresumed> getAllCircumstancesPresumed() {
        return circumstancesPresumedRepository.findAll();
    }

    @Override
    public Optional<CircumstancesPresumed> getCircumstancesPresumedById(Long id) {
        return circumstancesPresumedRepository.findById(id);
    }
}
