package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.service.input.RingedBirdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ringedBird")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class RingedBirdController {
    private RingedBirdService ringedBirdService;

    @GetMapping
    public List<RingedBird> getAllRingedBird() {
        return ringedBirdService.getAllRingedBird();
    }

    @GetMapping("/{id}")
    public Optional<RingedBird> getRingedBirdById(@PathVariable Long id) {
        return ringedBirdService.getRingedBirdById(id);
    }
}
