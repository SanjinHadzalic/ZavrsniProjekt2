package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.AccuracyOfPullusAge;
import org.springframework.boot.backend.service.input.AccuracyOfPullusAgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accuracyOfPullusAge")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class AccuracyOfPullusAgeController {
    private AccuracyOfPullusAgeService accuracyOfPullusAgeService;

    @GetMapping
    public List<AccuracyOfPullusAge> getAllAccuracyOfPullusAges() {
        return accuracyOfPullusAgeService.getAllAccuracyOfPullusAges();
    }

    @GetMapping("/{id}")
    public Optional<AccuracyOfPullusAge> getAccuracyOfPullusAgeById(@PathVariable Long id) {
        return accuracyOfPullusAgeService.getAccuracyOfPullusAgeById(id);
    }
}
