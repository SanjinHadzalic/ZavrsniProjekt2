package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.Moult;
import org.springframework.boot.backend.service.input.MoultService;
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
