package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.PrimaryIdentificationMethod;
import org.springframework.boot.backend.service.input.PrimaryIdentificationMethodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/primaryIdentificationMethod")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PrimaryIdentificationMethodController {
    private PrimaryIdentificationMethodService primaryIdentificationMethodService;

    @GetMapping
    public List<PrimaryIdentificationMethod> getAllPrimaryIdentificationMethods() {
        log.info("Called method getAllPrimaryIdentificationMethods()");
        return primaryIdentificationMethodService.getAllPrimaryIdentificationMethods();
    }

    @GetMapping("/{id}")
    public Optional<PrimaryIdentificationMethod> getPrimaryIdentificationMethodById(@PathVariable Long id) {
        log.info("Called method getPrimaryIdentificationMethodById() with id= " + id);
        return primaryIdentificationMethodService.getPrimaryIdentificationMethodById(id);
    }
}
