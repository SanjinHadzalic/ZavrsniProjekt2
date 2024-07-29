package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.command.PlaceCommand;
import org.springframework.boot.backend.entity.input.Place;
import org.springframework.boot.backend.repository.input.PlaceRepository;
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

    @Override
    public Place createNewPlace(PlaceCommand placeCommand) {
        Place place = new Place();
        place.setId(generateMaxId());
        place.setName(placeCommand.getName());
        place.setCountry(placeCommand.getCountry());
        place.setRegionCode(placeCommand.getRegionCode());
        place.setLatitude(placeCommand.getLatitude());
        place.setLongitude(placeCommand.getLongitude());
        place.setNotes(placeCommand.getNotes());
        place.setPrecision(placeCommand.getPrecision());

        return placeRepository.save(place);
    }

    @Override
    public Place updatePlace(Long id, PlaceCommand placeCommand) {
        Optional<Place> existingPlaceOpt = placeRepository.findById(id);
        if (existingPlaceOpt.isPresent()) {
            Place place = existingPlaceOpt.get();
            place.setName(placeCommand.getName());
            place.setCountry(placeCommand.getCountry());
            place.setRegionCode(placeCommand.getRegionCode());
            place.setLatitude(placeCommand.getLatitude());
            place.setLongitude(placeCommand.getLongitude());
            place.setNotes(placeCommand.getNotes());
            place.setPrecision(placeCommand.getPrecision());

            return placeRepository.save(place);
        } else {
            throw new RuntimeException("Place not found with id= " + id);
        }
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    private Long generateMaxId() {
        return getAllPlaces().stream().map(Place::getId).max(Long::compare).get() + 1L;
    }
}
