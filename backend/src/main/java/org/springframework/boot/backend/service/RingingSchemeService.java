package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.RingingScheme;

import java.util.List;
import java.util.Optional;

public interface RingingSchemeService {
    List<RingingScheme> getAllRingingSchemes();
    Optional<RingingScheme>  getRingingSchemeById(Long id);
    RingingScheme save(RingingScheme ringingScheme);
    RingingScheme update(Long id, RingingScheme ringingScheme);
    void delete(Long id);
}
