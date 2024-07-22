package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.MetalRingInformation;
import org.springframework.boot.backend.repository.MetalRingInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MetalRingInformationServiceImpl implements MetalRingInformationService{
    private MetalRingInformationRepository metalRingInformationRepository;
    @Override
    public List<MetalRingInformation> getAllMetalRingInformations() {
        return metalRingInformationRepository.findAll();
    }

    @Override
    public Optional<MetalRingInformation> getMetalRingInformationById(Long id) {
        return metalRingInformationRepository.findById(id);
    }
}
