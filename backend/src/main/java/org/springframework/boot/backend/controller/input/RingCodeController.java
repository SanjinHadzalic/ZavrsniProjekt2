package org.springframework.boot.backend.controller.input;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.command.RingCodeCommand;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.service.input.RingCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ringCode")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class RingCodeController {
    private RingCodeService ringCodeService;

    @GetMapping
    public List<RingCode> getAllRingCodes() {
        log.info("Called method getAllRingCodes()");
        return ringCodeService.getAllRingCodes();
    }

    @GetMapping("/user/{username}/email/{email}")
    public ResponseEntity<List<RingCode>> getAllRingCodesByUsernameAndEmail(
            @PathVariable String username,
            @PathVariable String email) {

        List<RingCode> ringCodes = ringCodeService.getAllRingCodeByUsernameAndEmail(username, email);

        if (ringCodes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ringCodes);
    }

    @GetMapping("/{id}")
    public Optional<RingCode> getRingCodeById(@PathVariable Long id) {
        log.info("Called method getRingCodeById() with id= " + id);
        return ringCodeService.getRingCodeById(id);
    }

    @PostMapping("/generate")
    public List<RingCode> generateNewRingCode(@RequestParam String username,
                                              @RequestParam String code,
                                              @RequestParam Integer range) {
        return ringCodeService.generateNewRingCode(username, code, range);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RingCode> updateRingCode(@PathVariable Long id, @RequestBody @Valid final RingCodeCommand toBeUpdated) {
        log.info("Called method updateRingCode() with id= " + id + " and body= " + toBeUpdated .toString());
        return ResponseEntity.ok(ringCodeService.updateRingCode(id, toBeUpdated));
    }

    @DeleteMapping("/{id}")
    public void deleteRingCodeById(@PathVariable Long id) {
        log.info("Called method deleteRingCodeById() with id= " + id);
        ringCodeService.deleteRingCodeById(id);
    }
}
