package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.CatchingMethods;
import org.springframework.boot.backend.service.CatchingMethodsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catchingMethods")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CatchingMethodsController {
    private CatchingMethodsService catchingMethodsService;

    @GetMapping
    public List<CatchingMethods> getAllCatchingMethods() {
        return catchingMethodsService.getAllCatchingMethods();
    }

    @GetMapping("/{id}")
    public Optional<CatchingMethods> getCatchingMethodsById(@PathVariable Long id) {
        return catchingMethodsService.getCatchingMethodsById(id);
    }
}
