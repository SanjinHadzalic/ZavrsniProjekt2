package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Place;
import org.springframework.boot.backend.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService{
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public Optional<Place> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }
}
