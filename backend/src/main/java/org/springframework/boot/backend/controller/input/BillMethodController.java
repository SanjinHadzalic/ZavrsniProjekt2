package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.BillMethod;
import org.springframework.boot.backend.service.input.BillMethodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billMethod")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class BillMethodController {
    private BillMethodService billMethodService;

    @GetMapping
    public List<BillMethod> getAllBillMethods() {
        return billMethodService.getAllBillMethods();
    }

    @GetMapping("/{id}")
    public Optional<BillMethod> getBillMethodById(@PathVariable Long id) {
        return billMethodService.getBillMethodById(id);
    }
}
