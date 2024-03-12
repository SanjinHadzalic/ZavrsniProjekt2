package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {
    List<Place> getAllPlaces();
    Optional<Place> getPlaceById(Long id);
}
