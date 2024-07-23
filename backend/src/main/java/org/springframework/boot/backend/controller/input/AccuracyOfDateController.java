package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.AccuracyOfDate;
import org.springframework.boot.backend.service.input.AccuracyOfDateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accuracyOfDate")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class AccuracyOfDateController {
    private AccuracyOfDateService accuracyOfDateService;

    @GetMapping
    public List<AccuracyOfDate> getAllAccuracyOfDates() {
        return accuracyOfDateService.getAllAccuracyOfDates();
    }

    @GetMapping("/{id}")
    public Optional<AccuracyOfDate> getAccuracyOfDateById(@PathVariable Long id) {
        return accuracyOfDateService.getAccuracyOfDateById(id);
    }
}
