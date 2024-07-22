package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Manipulated;
import org.springframework.boot.backend.repository.ManipulatedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManipulatedServiceImpl implements ManipulatedService{
    private ManipulatedRepository manipulatedRepository;

    @Override
    public List<Manipulated> getAllManipulated() {
        return manipulatedRepository.findAll();
    }

    @Override
    public Optional<Manipulated> getManipulatedById(Long id) {
        return manipulatedRepository.findById(id);
    }
}
