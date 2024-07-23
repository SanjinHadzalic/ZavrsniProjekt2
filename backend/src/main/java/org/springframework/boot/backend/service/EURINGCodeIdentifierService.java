package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.EURINGCodeIdentifier;

import java.util.List;
import java.util.Optional;

public interface EURINGCodeIdentifierService {
    List<EURINGCodeIdentifier> getAllEURINGCodeIdentifier();
    Optional<EURINGCodeIdentifier> getEURINGCodeIdentifierById(Long id);
}
