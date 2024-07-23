package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.Manipulated;
import org.springframework.boot.backend.service.input.ManipulatedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manipulated")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ManipulatedController {
    private ManipulatedService manipulatedService;

    @GetMapping
    public List<Manipulated> getAllManipulated() {
        return manipulatedService.getAllManipulated();
    }

    @GetMapping("/{id}")
    public Optional<Manipulated> getManipulatedById(@PathVariable Long id) {
        return manipulatedService.getManipulatedById(id);
    }
}
