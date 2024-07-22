package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.PullusAge;

import java.util.List;
import java.util.Optional;

public interface PullusAgeService {
    List<PullusAge> getAllPullusAges();
    Optional<PullusAge> getPullusAgeById(Long id);
}
