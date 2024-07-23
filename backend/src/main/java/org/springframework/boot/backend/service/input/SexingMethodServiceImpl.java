package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.SexingMethod;
import org.springframework.boot.backend.repository.input.SexingMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SexingMethodServiceImpl implements SexingMethodService{
    private SexingMethodRepository sexingMethodRepository;
    @Override
    public List<SexingMethod> getAllSexingMethods() {
        return sexingMethodRepository.findAll();
    }

    @Override
    public Optional<SexingMethod> getSexingMethodById(Long id) {
        return sexingMethodRepository.findById(id);
    }
}
