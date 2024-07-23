package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.PullusAge;
import org.springframework.boot.backend.service.input.PullusAgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pullusAge")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class PullusAgeController {
    private PullusAgeService pullusAgeService;

    @GetMapping
    public List<PullusAge> getAllPullusAges() {
        return pullusAgeService.getAllPullusAges();
    }

    @GetMapping("/{id}")
    public Optional<PullusAge> getPullusAgeById(@PathVariable Long id) {
        return pullusAgeService.getPullusAgeById(id);
    }
}
