package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.VerificationOfTheMetalRing;
import org.springframework.boot.backend.service.VerificationOfTheMetalRingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/verificationOfTheMetalRing")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class VerificationOfTheMetalRingController {

    private VerificationOfTheMetalRingService verificationOfTheMetalRingService;

    @GetMapping
    public List<VerificationOfTheMetalRing> getAllVerificationOfTheMetalRings() {
        return verificationOfTheMetalRingService.getAllVerificationOfTheMetalRings();
    }

    @GetMapping("/{id}")
    public Optional<VerificationOfTheMetalRing> getVerificationOfTheMetalRingById(@PathVariable Long id) {
        return verificationOfTheMetalRingService.getVerificationOfTheMetalRingById(id);
    }
}
