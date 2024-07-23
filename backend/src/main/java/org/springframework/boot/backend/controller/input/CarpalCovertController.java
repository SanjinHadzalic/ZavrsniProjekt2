package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.CarpalCovert;
import org.springframework.boot.backend.service.input.CarpalCovertService;
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
