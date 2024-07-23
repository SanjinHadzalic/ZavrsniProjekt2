package org.springframework.boot.backend.controller.input;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.input.OtherMarksInformation;
import org.springframework.boot.backend.service.input.OtherMarksInformationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/otherMarksInformation")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class OtherMarksInformationController {
    private OtherMarksInformationService otherMarksInformationService;

    @GetMapping
    public List<OtherMarksInformation> getAllAllOtherMarksInformation() {
        log.info("Called method getAllAllOtherMarksInformation()");
        return otherMarksInformationService.getAllOtherMarksInformation();
    }

    @GetMapping("/{id}")
    public Optional<OtherMarksInformation> getOtherMarksInformationById(@PathVariable Long id) {
        log.info("Called method getOtherMarksInformationById() with id= " + id);
        return otherMarksInformationService.getOtherMarksInformationById(id);
    }
}
