package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Bird;
import org.springframework.boot.backend.service.BirdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/birds")
@AllArgsConstructor
public class BirdController {
    private BirdService birdService;

    @GetMapping
    List<Bird> all() {
        return birdService.getAllBirds();
    }

    @GetMapping("/{id}")
    Optional<Bird> getBirdById(@PathVariable Long id) {
        return birdService.getBird(id);
    }
}
