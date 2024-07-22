package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.Sex;
import org.springframework.boot.backend.service.SexService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sex")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class SexController {
    private SexService sexService;

    @GetMapping
    public List<Sex> getAllSexes() {
        return sexService.getAllSexes();
    }

    @GetMapping("/{id}")
    public Optional<Sex> getSexById(@PathVariable Long id) {
        return sexService.findSexById(id);
    }
}
