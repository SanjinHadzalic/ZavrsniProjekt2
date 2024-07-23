package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.MetalRingInformation;
import org.springframework.boot.backend.service.input.MetalRingInformationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metalRingInformation")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class MetalRingInformationController {
    private MetalRingInformationService metalRingInformationService;

    @GetMapping
    public List<MetalRingInformation> getAllMetalRingInformation() {
        return metalRingInformationService.getAllMetalRingInformations();
    }

    @GetMapping("/{id}")
    public Optional<MetalRingInformation> getMetalRingInformationById(@PathVariable Long id) {
        return metalRingInformationService.getMetalRingInformationById(id);
    }
}
