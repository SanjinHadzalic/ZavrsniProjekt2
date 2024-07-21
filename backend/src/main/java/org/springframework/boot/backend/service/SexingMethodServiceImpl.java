package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.SexingMethod;
import org.springframework.boot.backend.repository.SexingMethodRepository;
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
