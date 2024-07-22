package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.BroodSize;
import org.springframework.boot.backend.service.BroodSizeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/broodSize")
@AllArgsConstructor
@Slf4j
public class BroodSizeController {
    private BroodSizeService broodSizeService;

    @GetMapping
    public List<BroodSize> getAllBroodSizes() {
        return broodSizeService.getAllBroodSizes();
    }

    @GetMapping("/{id}")
    public Optional<BroodSize> getBroodSizeById(@PathVariable Long id) {
        return broodSizeService.getBroodSizeById(id);
    }
}
