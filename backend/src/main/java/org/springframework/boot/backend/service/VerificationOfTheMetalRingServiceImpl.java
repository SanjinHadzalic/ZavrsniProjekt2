package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.VerificationOfTheMetalRing;
import org.springframework.boot.backend.repository.VerificationOfTheMetalRingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationOfTheMetalRingServiceImpl implements VerificationOfTheMetalRingService{

    private VerificationOfTheMetalRingRepository verificationOfTheMetalRingRepository;

    @Override
    public List<VerificationOfTheMetalRing> getAllVerificationOfTheMetalRings() {
        return verificationOfTheMetalRingRepository.findAll();
    }

    @Override
    public Optional<VerificationOfTheMetalRing> getVerificationOfTheMetalRingById(Long id) {
        return verificationOfTheMetalRingRepository.findById(id);
    }
}
