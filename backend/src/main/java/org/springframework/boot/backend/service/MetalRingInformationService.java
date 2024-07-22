package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.MetalRingInformation;

import java.util.List;
import java.util.Optional;

public interface MetalRingInformationService {

    List<MetalRingInformation> getAllMetalRingInformations();
    Optional<MetalRingInformation> getMetalRingInformationById(Long id);
}
