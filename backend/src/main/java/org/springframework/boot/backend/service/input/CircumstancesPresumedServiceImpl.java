package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.CircumstancesPresumed;
import org.springframework.boot.backend.repository.input.CircumstancesPresumedRepository;
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
