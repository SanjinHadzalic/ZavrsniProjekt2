package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.service.input.RingCodeService;
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

    @GetMapping("/{id}")
    public Optional<RingCode> getRingCodeById(@PathVariable Long id) {
        log.info("Called method getRingCodeById() with id= " + id);
        return ringCodeService.getRingCodeById(id);
    }
}