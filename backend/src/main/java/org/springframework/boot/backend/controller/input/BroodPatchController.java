package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.BroodPatch;
import org.springframework.boot.backend.service.input.BroodPatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/broodPatch")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class BroodPatchController {
    private BroodPatchService broodPatchService;

    @GetMapping
    public List<BroodPatch> getAllBroodPatches() {
        return broodPatchService.getAllBroodPatches();
    }

    @GetMapping("/{id}")
    public Optional<BroodPatch> getBroodPatchById(@PathVariable Long id) {
        return broodPatchService.getBroodPatchById(id);
    }
}
