package org.springframework.boot.backend.controller.input;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.command.RingedBirdCommand;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.service.input.RingedBirdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/code/{code}")
    public RingedBird getRingedBirdByCode(@PathVariable String code) {
        return ringedBirdService.getRingedBirdByCode(code).get();
    }
    @GetMapping("/ringCode/{code}")
    public ResponseEntity<List<RingedBird>> getAllRingedBirdsByCode(@PathVariable String code) {
        List<RingedBird> ringedBirds = ringedBirdService.getAllRingedBirdByCode(code);
        return ResponseEntity.ok(ringedBirds);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<RingedBird>> getAllRingedBirdOfUser(@PathVariable String username) {
        List<RingedBird> ringedBirdsByUser = ringedBirdService.getAllRingedBirdOfUser(username);
        log.info("Called method getAllRingedBirdOfUser() with username= " + username + ", list.size() is= " + ringedBirdsByUser.size());


        return ResponseEntity.ok(ringedBirdsByUser);
    }

    @PostMapping
    public RingedBird createRingedBird(@Valid @RequestBody RingedBirdCommand ringedBirdCommand) {
        return ringedBirdService.createNewRingedBird(ringedBirdCommand);
    }

    @PostMapping("/ringCode/{ringCode}")
    public ResponseEntity<RingedBird> createNewRingedBirdFromExisting(@PathVariable String ringCode, @RequestBody RingedBirdCommand ringedBirdCommand) {
        try {
            RingedBird ringedBird = ringedBirdService.createNewRingedBirdFromExisting(ringCode, ringedBirdCommand);
            return ResponseEntity.status(HttpStatus.CREATED).body(ringedBird);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
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
