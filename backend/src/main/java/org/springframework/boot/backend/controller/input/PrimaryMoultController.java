package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.PrimaryMoult;
import org.springframework.boot.backend.service.input.PrimaryMoultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/primaryMoult")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PrimaryMoultController {

    private PrimaryMoultService primaryMoultService;

    @GetMapping
    public List<PrimaryMoult> getAllPrimaryMoults() {
        return primaryMoultService.getAllPrimaryMoults();
    }

    @GetMapping("/{id}")
    public Optional<PrimaryMoult> getPrimaryMoultById(@PathVariable Long id) {
        return primaryMoultService.getPrimaryMoultById(id);
    }
}
