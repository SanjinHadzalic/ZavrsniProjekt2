package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.CatchingLures;
import org.springframework.boot.backend.service.CatchingLuresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catchingLures")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CatchingLuresController {
    private CatchingLuresService catchingLuresService;

    @GetMapping
    public List<CatchingLures> getAllCatchingLures() {
        return catchingLuresService.getAllCatchingLures();
    }

    @GetMapping("/{id}")
    public Optional<CatchingLures> getCatchingLuresById(@PathVariable Long id) {
        return catchingLuresService.getCatchingLuresById(id);
    }
}
