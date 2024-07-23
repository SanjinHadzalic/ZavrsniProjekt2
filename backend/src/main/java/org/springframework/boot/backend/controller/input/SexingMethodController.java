package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.SexingMethod;
import org.springframework.boot.backend.service.input.SexingMethodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sexingMethod")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class SexingMethodController {
    private SexingMethodService sexingMethodService;

    @GetMapping
    List<SexingMethod> getAllSexingMethods() {
        log.info("Called method getAllSexingMethods()");
        return sexingMethodService.getAllSexingMethods();
    }

    @GetMapping("/{id}")
    Optional<SexingMethod> getSexingMethodById(@PathVariable Long id) {
        log.info("Called method getSexingMethodById(), id= " + id);
        return sexingMethodService.getSexingMethodById(id);
    }
}
