package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.PrimaryIdentificationMethod;
import org.springframework.boot.backend.repository.input.PrimaryIdentificationMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrimaryIdentificationMethodServiceImpl implements PrimaryIdentificationMethodService{

    private PrimaryIdentificationMethodRepository primaryIdentificationMethodRepository;

    @Override
    public List<PrimaryIdentificationMethod> getAllPrimaryIdentificationMethods() {
        return primaryIdentificationMethodRepository.findAll();
    }

    @Override
    public Optional<PrimaryIdentificationMethod> getPrimaryIdentificationMethodById(Long id) {
        return primaryIdentificationMethodRepository.findById(id);
    }
}
