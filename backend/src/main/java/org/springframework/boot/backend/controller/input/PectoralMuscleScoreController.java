package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.PectoralMuscleScore;
import org.springframework.boot.backend.service.input.PectoralMuscleScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pectoralMuscleScore")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PectoralMuscleScoreController {
    private PectoralMuscleScoreService pectoralMuscleScoreService;

    @GetMapping
    public List<PectoralMuscleScore> getAllPectoralMuscleScores() {
        return pectoralMuscleScoreService.getAllPectoralMuscleScores();
    }

    @GetMapping("/{id}")
    public Optional<PectoralMuscleScore> getPectoralMuscleScoreById(@PathVariable Long id) {
        return pectoralMuscleScoreService.getPectoralMuscleScoreById(id);
    }
}
