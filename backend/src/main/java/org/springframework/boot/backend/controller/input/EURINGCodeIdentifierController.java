package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.EURINGCodeIdentifier;
import org.springframework.boot.backend.service.input.EURINGCodeIdentifierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/euring_code_identifier")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class EURINGCodeIdentifierController {
    private EURINGCodeIdentifierService euringCodeIdentifierService;

    @GetMapping
    public List<EURINGCodeIdentifier> getAllEURINGCodeIdentifier() {
        return euringCodeIdentifierService.getAllEURINGCodeIdentifier();
    }

    @GetMapping("/{id}")
    public Optional<EURINGCodeIdentifier> getEURINGCodeIdentifierById(@PathVariable Long id) {
        return euringCodeIdentifierService.getEURINGCodeIdentifierById(id);
    }
}
