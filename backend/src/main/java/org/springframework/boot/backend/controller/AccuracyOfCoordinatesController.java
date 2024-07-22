package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.AccuracyOfCoordinates;
import org.springframework.boot.backend.service.AccuracyOfCoordinatesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accuracyOfCoordinates")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class AccuracyOfCoordinatesController {
    private AccuracyOfCoordinatesService accuracyOfCoordinatesService;

    @GetMapping
    public List<AccuracyOfCoordinates> getAllAccuracyOfCoordinates() {
        return accuracyOfCoordinatesService.getAllAccuracyOfCoordinates();
    }

    @GetMapping("/{id}")
    public Optional<AccuracyOfCoordinates> getAccuracyOfCoordinatesById(@PathVariable Long id) {
        return accuracyOfCoordinatesService.getAccuracyOfCoordinatesById(id);
    }
}
