package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.VerificationOfTheMetalRing;

import java.util.List;
import java.util.Optional;

public interface VerificationOfTheMetalRingService {
    List<VerificationOfTheMetalRing> getAllVerificationOfTheMetalRings();
    Optional<VerificationOfTheMetalRing> getVerificationOfTheMetalRingById(Long id);
}
