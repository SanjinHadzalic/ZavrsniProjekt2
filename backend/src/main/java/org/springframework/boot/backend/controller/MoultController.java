package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.Moult;
import org.springframework.boot.backend.service.MoultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moult")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class MoultController {
    private MoultService moultService;

    @GetMapping
    public List<Moult> getAllMoults() {
        return moultService.getAllMoults();
    }

    @GetMapping("/{id}")
    public Optional<Moult> getMoultById(@PathVariable Long id) {
        return moultService.getMoultById(id);
    }
}
