package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.Age;
import org.springframework.boot.backend.service.input.AgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/age")
@AllArgsConstructor
@Slf4j
public class AgeController {
    private AgeService ageService;

    @GetMapping
    public List<Age> getAllAges() {
        return ageService.getAllAges();
    }

    @GetMapping("/{id}")
    public Optional<Age> getAgeById(@PathVariable Long id) {
        return ageService.getAgeById(id);
    }
}
