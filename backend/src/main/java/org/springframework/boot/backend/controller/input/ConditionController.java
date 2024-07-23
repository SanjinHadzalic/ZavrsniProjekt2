package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.Condition;
import org.springframework.boot.backend.service.input.ConditionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/condition")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class ConditionController {
    private ConditionService conditionService;

    @GetMapping
    public List<Condition> getAllConditions() {
        return conditionService.getAllConditions();
    }

    @GetMapping("/{id}")
    public Optional<Condition> getConditionById(@PathVariable Long id) {
        return conditionService.getConditionById(id);
    }
}
