package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.MetalRingInformation;

import java.util.List;
import java.util.Optional;

public interface MetalRingInformationService {

    List<MetalRingInformation> getAllMetalRingInformations();
    Optional<MetalRingInformation> getMetalRingInformationById(Long id);
}
