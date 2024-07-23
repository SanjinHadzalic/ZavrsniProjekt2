package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.PlumageCode;
import org.springframework.boot.backend.service.PlumageCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plumageCode")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PlumageCodeController {
    private PlumageCodeService plumageCodeService;

    @GetMapping
    public List<PlumageCode> getAllPlumageCodes() {
        return plumageCodeService.getAllPlumageCodes();
    }

    @GetMapping("/{id}")
    public Optional<PlumageCode> getPlumageCodeById(@PathVariable Long id) {
        return plumageCodeService.getPlumageCodeById(id);
    }
}
