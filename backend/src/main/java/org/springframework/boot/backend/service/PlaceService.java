package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
}
