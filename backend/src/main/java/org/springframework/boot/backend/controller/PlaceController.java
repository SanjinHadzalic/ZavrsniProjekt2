package org.springframework.boot.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Place;
import org.springframework.boot.backend.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PlaceController {
    private PlaceService placeService;

    @GetMapping("")
    public List<Place> getPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping(value = "/{id}")
    public Optional<Place> getPlaceById(@PathVariable("id") Long id) {
        return placeService.getPlaceById(id);
    }
}
