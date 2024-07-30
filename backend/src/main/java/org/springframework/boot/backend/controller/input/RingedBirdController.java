package org.springframework.boot.backend.controller.input;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.command.RingedBirdCommand;
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
        log.info("Called method getAllRingedBird()");
        return ringedBirdService.getAllRingedBird();
    }

    @GetMapping("/{id}")
    public Optional<RingedBird> getRingedBirdById(@PathVariable Long id) {
        log.info("Called method getRingedBirdById with id= " + id);
        return ringedBirdService.getRingedBirdById(id);
    }

    @PostMapping
    public RingedBird createRingedBird(@Valid @RequestBody RingedBirdCommand ringedBirdCommand) {
        return ringedBirdService.createNewRingedBird(ringedBirdCommand);
    }

    @PutMapping("/{id}")
    public RingedBird updateRingedBird(@PathVariable Long id, @Valid @RequestBody RingedBirdCommand ringedBirdCommand) {
        return ringedBirdService.updateRingedBird(id, ringedBirdCommand);
    }

    @DeleteMapping("/{id}")
    public void deleteRingedBirdById(@PathVariable Long id) {
        ringedBirdService.deleteRingedBirdById(id);
    }
}
