package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.Place;
import org.springframework.boot.backend.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class PlaceController {
    private PlaceService placeService;

    @GetMapping
    public List<Place> getPlaces() {
        log.info("Called method getPlaces()");
        return placeService.getAllPlaces();
    }

    @GetMapping(value = "/{id}")
    public Optional<Place> getPlaceById(@PathVariable("id") Long id) {
        log.info("Called method getPlaceById() with id: " + id);
        return placeService.getPlaceById(id);
    }
}
