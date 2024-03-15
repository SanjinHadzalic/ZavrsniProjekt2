package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Bird;
import org.springframework.boot.backend.service.BirdService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class BirdController {
    private BirdService birdService;

    @GetMapping("/birds")
    List<Bird> all() {
        return birdService.getAllBirds();
    }

}
