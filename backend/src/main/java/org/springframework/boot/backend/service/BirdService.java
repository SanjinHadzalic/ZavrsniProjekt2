package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Bird;

import java.util.List;
import java.util.Optional;

public interface BirdService {
    List<Bird> getAllBirds();
    Optional<Bird> getBird(Long id);
}
