package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.PrimaryIdentificationMethod;

import java.util.List;
import java.util.Optional;

public interface PrimaryIdentificationMethodService {
    List<PrimaryIdentificationMethod> getAllPrimaryIdentificationMethods();
    Optional<PrimaryIdentificationMethod> getPrimaryIdentificationMethodById(Long id);
}
