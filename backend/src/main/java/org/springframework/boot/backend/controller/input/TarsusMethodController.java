package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.TarsusMethod;
import org.springframework.boot.backend.service.input.TarsusMethodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarsusMethod")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class TarsusMethodController {
    private TarsusMethodService tarsusMethodService;

    @GetMapping
    public List<TarsusMethod> getAllTarsusMethods() {
        return tarsusMethodService.getAllTarsusMethods();
    }

    @GetMapping("/{id}")
    public Optional<TarsusMethod> getTarsusMethodById(@PathVariable Long id) {
        return tarsusMethodService.getTarsusMethodById(id);
    }
}
