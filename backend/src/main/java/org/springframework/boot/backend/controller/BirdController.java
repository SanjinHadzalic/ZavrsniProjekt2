package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.Bird;
import org.springframework.boot.backend.service.BirdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/birds")
@AllArgsConstructor
@Slf4j
public class BirdController {
    private BirdService birdService;

    @GetMapping
    List<Bird> all() {
        log.info("Called method getAllBirds()");
        return birdService.getAllBirds();
    }

    @GetMapping("/{id}")
    Optional<Bird> getBirdById(@PathVariable Long id) {
        log.info("Called method getBirdById() with id: " + id);
        return birdService.getBird(id);
    }
}
