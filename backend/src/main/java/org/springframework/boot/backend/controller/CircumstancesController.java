package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.Circumstances;
import org.springframework.boot.backend.service.CircumstancesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/circumstances")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class CircumstancesController {
    private CircumstancesService circumstancesService;

    @GetMapping
    public List<Circumstances> getAllCircumstances() {
        return circumstancesService.getAllCircumstances();
    }

    @GetMapping("/{id}")
    public Optional<Circumstances> getCircumstancesById(@PathVariable Long id) {
        return circumstancesService.getCircumstancesById(id);
    }
}
