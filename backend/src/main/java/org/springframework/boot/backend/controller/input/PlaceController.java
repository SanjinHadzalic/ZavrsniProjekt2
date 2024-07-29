package org.springframework.boot.backend.controller.input;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.entity.command.PlaceCommand;
import org.springframework.boot.backend.entity.input.Place;
import org.springframework.boot.backend.service.input.PlaceService;
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

    @PostMapping
    public Place createPlace(@Valid @RequestBody PlaceCommand placeCommand) {
        log.info("Called method createPlace() with data= " + placeCommand.toString());
        return placeService.createNewPlace(placeCommand);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id, @Valid @RequestBody PlaceCommand placeCommand) {
        log.info("Called method updatePlace() with id= " + id + " and data= " + placeCommand.toString());
        return placeService.updatePlace(id, placeCommand);
    }

    @DeleteMapping("/{id}")
    public void deletePlaceById(@PathVariable Long id) {
        log.info("Called method deletePlaceById() with id= " + id);
        placeService.deletePlaceById(id);
    }
}
