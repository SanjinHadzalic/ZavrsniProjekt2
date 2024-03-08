package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Bird;

import java.util.List;

public interface BirdService {
    List<Bird> getAllBirds();
}
