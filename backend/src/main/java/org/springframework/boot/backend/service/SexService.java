package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Sex;

import java.util.List;
import java.util.Optional;

public interface SexService {
    List<Sex> getAllSexes();
    Optional<Sex> findSexById(Long id);
}
