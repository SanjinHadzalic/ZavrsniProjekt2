package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.CarpalCovert;
import org.springframework.boot.backend.service.CarpalCovertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carpalCovert")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CarpalCovertController {
    private CarpalCovertService carpalCovertService;

    @GetMapping
    public List<CarpalCovert> getAllCarpalCoverts() {
        return carpalCovertService.getAllCarpalCoverts();
    }

    @GetMapping("/{id}")
    public Optional<CarpalCovert> getCarpalCovertById(@PathVariable Long id) {
        return carpalCovertService.getCarpalCovertById(id);
    }
}
