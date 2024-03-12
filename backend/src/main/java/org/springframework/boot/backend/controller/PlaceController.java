package org.springframework.boot.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.backend.entity.Place;
import org.springframework.boot.backend.service.PlaceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/all")
    public List<Place> getPlaces() {
        return placeService.getAllPlaces();
    }

}
