package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.EURINGCodeIdentifier;
import org.springframework.boot.backend.repository.EURINGCodeIdentifierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EURINGCodeIdentifierServiceImpl implements EURINGCodeIdentifierService{
    private EURINGCodeIdentifierRepository euringCodeIdentifierRepository;
    @Override
    public List<EURINGCodeIdentifier> getAllEURINGCodeIdentifier() {
        return euringCodeIdentifierRepository.findAll();
    }

    @Override
    public Optional<EURINGCodeIdentifier> getEURINGCodeIdentifierById(Long id) {
        return euringCodeIdentifierRepository.findById(id);
    }
}
