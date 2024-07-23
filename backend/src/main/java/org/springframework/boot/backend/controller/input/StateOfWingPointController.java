package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.StateOfWingPoint;
import org.springframework.boot.backend.service.input.StateOfWingPointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stateOfWingPoint")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class StateOfWingPointController {
    private StateOfWingPointService stateOfWingPointService;

    @GetMapping
    public List<StateOfWingPoint> getAllStateOfWingPoints() {
        return stateOfWingPointService.getAllStateOfWingPoint();
    }

    @GetMapping("/{id}")
    public Optional<StateOfWingPoint> getStateOfWingPointById(@PathVariable Long id) {
        return stateOfWingPointService.getStateOfWingPointById(id);
    }

}
