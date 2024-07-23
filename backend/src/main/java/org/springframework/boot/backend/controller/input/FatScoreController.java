package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.FatScore;
import org.springframework.boot.backend.service.input.FatScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fatScore")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class FatScoreController {
    private final FatScoreService fatScoreService;

    @GetMapping
    public List<FatScore> getAllFatScores() {
        return fatScoreService.getAllFatScores();
    }

    @GetMapping("/{id}")
    public Optional<FatScore> getFatScore(@PathVariable Long id) {
        return fatScoreService.getFatScore(id);
    }
}
