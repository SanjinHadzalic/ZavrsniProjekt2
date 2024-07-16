package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.RingingScheme;
import org.springframework.boot.backend.service.RingingSchemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ringingScheme")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class RingingSchemeController {
    private RingingSchemeService ringingSchemeService;

    @GetMapping
    public List<RingingScheme> getRingingSchemes() {
        log.info("Called method getRingingSchemes");
        return ringingSchemeService.getAllRingingSchemes();
    }

    @GetMapping(value = "/{id}")
    public Optional<RingingScheme> getRingingSchemeById(@PathVariable("id") Long id) {
        log.info("Called method getRingingSchemeById() with id: " + id);
        return ringingSchemeService.getRingingSchemeById(id);
    }
}
