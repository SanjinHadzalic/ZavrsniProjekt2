package org.springframework.boot.backend.service.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.backend.entity.command.RingedBirdCommand;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.repository.input.RingedBirdRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class RingedBirdServiceImplTest {
    @Mock
    private RingedBirdRepository ringedBirdRepository;

    @InjectMocks
    private RingedBirdServiceImpl ringedBirdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRingedBird_Valid_ReturnsAllObjects() {
        RingedBird bird1 = new RingedBird();
        RingedBird bird2 = new RingedBird();
        List<RingedBird> expectedBirds = Arrays.asList(bird1, bird2);

        when(ringedBirdRepository.findAll()).thenReturn(expectedBirds);

        List<RingedBird> actualBirds = ringedBirdService.getAllRingedBird();

        assertEquals(expectedBirds, actualBirds);
        verify(ringedBirdRepository, times(1)).findAll();
    }

    @Test
    void getRingedBirdById_Valid_ReturnsSpecificObject() {
        Long id = 1L;
        RingedBird expectedBird = new RingedBird();
        expectedBird.setId(id);

        when(ringedBirdRepository.findById(id)).thenReturn(Optional.of(expectedBird));

        Optional<RingedBird> actualBird = ringedBirdService.getRingedBirdById(id);

        assertTrue(actualBird.isPresent());
        assertEquals(expectedBird, actualBird.get());
        verify(ringedBirdRepository, times(1)).findById(id);
    }

    @Test
    void createNewRingedBird_Valid_CreatesNewObject() {
        RingedBirdCommand command = new RingedBirdCommand();
        RingedBird expectedBird = new RingedBird();
        expectedBird.setId(1L);

        when(ringedBirdRepository.save(any(RingedBird.class))).thenReturn(expectedBird);
        when(ringedBirdRepository.findAll()).thenReturn(List.of());

        RingedBird actualBird = ringedBirdService.createNewRingedBird(command);

        assertEquals(expectedBird, actualBird);
        verify(ringedBirdRepository, times(1)).save(any(RingedBird.class));
    }

    @Test
    void updateRingedBird_Valid_UpdatesExistingObject() {
        Long id = 1L;
        RingedBirdCommand command = new RingedBirdCommand();
        RingedBird existingBird = new RingedBird();
        existingBird.setId(id);

        when(ringedBirdRepository.findById(id)).thenReturn(Optional.of(existingBird));
        when(ringedBirdRepository.save(any(RingedBird.class))).thenReturn(existingBird);

        RingedBird updatedBird = ringedBirdService.updateRingedBird(id, command);

        assertEquals(existingBird, updatedBird);
        verify(ringedBirdRepository, times(1)).findById(id);
        verify(ringedBirdRepository, times(1)).save(existingBird);
    }

    @Test
    void deleteRingedBirdById_Valid_DeleteSpecificObject() {
        Long id = 1L;

        doNothing().when(ringedBirdRepository).deleteById(id);

        ringedBirdService.deleteRingedBirdById(id);

        verify(ringedBirdRepository, times(1)).deleteById(id);
    }
}