package org.springframework.boot.backend.service.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.backend.entity.command.PlaceCommand;
import org.springframework.boot.backend.entity.input.Place;
import org.springframework.boot.backend.repository.input.PlaceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaceServiceImplTest {
    @Mock
    private PlaceRepository placeRepository;

    @InjectMocks
    private PlaceServiceImpl placeService;

    private Place placeOne;
    private Place placeTwo;
    private PlaceCommand placeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        placeOne = new Place();
        placeOne.setId(1L);
        placeOne.setName("Place 1");
        placeOne.setCountry("Country 1");
        placeOne.setRegionCode("R1");
        placeOne.setLatitude(1.0);
        placeOne.setLongitude(1.0);
        placeOne.setNotes("Notes 1");

        placeTwo = new Place();
        placeTwo.setId(2L);
        placeTwo.setName("Place 2");
        placeTwo.setCountry("Country 2");
        placeTwo.setRegionCode("R2");
        placeTwo.setLatitude(2.0);
        placeTwo.setLongitude(2.0);
        placeTwo.setNotes("Notes 2");

        placeCommand = new PlaceCommand();
        placeCommand.setName("Place 3");
        placeCommand.setCountry("Country 3");
        placeCommand.setRegionCode("R3");
        placeCommand.setLatitude(3.0);
        placeCommand.setLongitude(3.0);
        placeCommand.setNotes("Notes 3");
    }

    @Test
    void getAllPlaces_Valid_ReturnsAllObjects() {
        when(placeRepository.findAll()).thenReturn(Arrays.asList(placeOne, placeTwo));

        List<Place> places = placeService.getAllPlaces();

        assertEquals(2, places.size());
        verify(placeRepository, times(1)).findAll();
    }

    @Test
    void getPlaceById_Valid_ReturnsObjectById() {
        when(placeRepository.findById(1L)).thenReturn(Optional.of(placeOne));

        Optional<Place> place = placeService.getPlaceById(1L);

        assertTrue(place.isPresent());
        assertEquals("Place 1", place.get().getName());
        verify(placeRepository, times(1)).findById(1L);
    }

    @Test
    void createNewPlace_Valid_CreatesNewObject() {
        when(placeRepository.findAll()).thenReturn(Arrays.asList(placeOne, placeTwo));
        when(placeRepository.save(any(Place.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ArgumentCaptor<Place> placeCaptor = ArgumentCaptor.forClass(Place.class);

        Place newPlace = placeService.createNewPlace(placeCommand);

        verify(placeRepository, times(1)).save(placeCaptor.capture());
        Place capturedPlace = placeCaptor.getValue();

        assertEquals("Place 3", capturedPlace.getName());
        assertEquals("Country 3", capturedPlace.getCountry());
        assertEquals("R3", capturedPlace.getRegionCode());
        assertEquals(3.0, capturedPlace.getLatitude());
        assertEquals(3.0, capturedPlace.getLongitude());
        assertEquals("Notes 3", capturedPlace.getNotes());
        assertNotNull(newPlace.getId());
    }

    @Test
    void updatePlace_Valid_UpdatesObjectByGivenId() {
        when(placeRepository.findById(1L)).thenReturn(Optional.of(placeOne));
        when(placeRepository.save(any(Place.class))).thenReturn(placeOne);

        Place updatedPlace = placeService.updatePlace(1L, placeCommand);

        assertEquals("Place 3", updatedPlace.getName());
        verify(placeRepository, times(1)).findById(1L);
        verify(placeRepository, times(1)).save(any(Place.class));
    }

    @Test
    void deletePlaceById() {
        when(placeRepository.findById(1L)).thenReturn(Optional.of(placeOne));
        doNothing().when(placeRepository).deleteById(1L);

        placeService.deletePlaceById(1L);

        verify(placeRepository, times(1)).deleteById(1L);
    }
}