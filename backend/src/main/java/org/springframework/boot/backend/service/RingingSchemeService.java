package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.RingingScheme;

import java.util.List;
import java.util.Optional;

public interface RingingSchemeService {
    List<RingingScheme> getAllRingingSchemes();
    Optional<RingingScheme>  getRingingSchemeById(Long id);
}
