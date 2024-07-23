package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.MovedBeforeTheEncounter;
import org.springframework.boot.backend.repository.input.MovedBeforeTheEncounterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movedBeforeTheEncounter")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class MovedBeforeTheEncounterController {
    private MovedBeforeTheEncounterRepository movedBeforeTheEncounterRepository;

    @GetMapping
    public List<MovedBeforeTheEncounter> getAllMovedBeforeTheEncounter() {
        log.info("Called method getAllMovedBeforeTheEncounter()");
        return movedBeforeTheEncounterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MovedBeforeTheEncounter> getMovedBeforeTheEncounter(@PathVariable Long id) {
        log.info("Called method getMovedBeforeTheEncounter() with id= " + id);
        return movedBeforeTheEncounterRepository.findById(id);
    }
}
