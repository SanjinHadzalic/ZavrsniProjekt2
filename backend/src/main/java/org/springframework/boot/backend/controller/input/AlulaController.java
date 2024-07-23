package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.Alula;
import org.springframework.boot.backend.service.input.AlulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alula")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AlulaController {

    private AlulaService alulaService;

    @GetMapping
    public List<Alula> getAllAlulas() {
        return alulaService.getAllAlulas();
    }

    @GetMapping("/{id}")
    public Optional<Alula> getAlulaById(@PathVariable Long id) {
        return alulaService.getAlulaById(id);
    }
}
