package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.CircumstancesPresumed;
import org.springframework.boot.backend.service.CircumstancesPresumedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/circumstancesPresumed")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class CircumstancesPresumedController {
    private CircumstancesPresumedService circumstancesPresumedService;

    @GetMapping
    public List<CircumstancesPresumed> getAllCircumstancesPresumed() {
        return circumstancesPresumedService.getAllCircumstancesPresumed();
    }

    @GetMapping("/{id}")
    public Optional<CircumstancesPresumed> getCircumstancesPresumedById(@PathVariable Long id) {
        return circumstancesPresumedService.getCircumstancesPresumedById(id);
    }
}
