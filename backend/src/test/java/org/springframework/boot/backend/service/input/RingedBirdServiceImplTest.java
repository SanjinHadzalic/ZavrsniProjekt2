package org.springframework.boot.backend.service.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.backend.entity.command.RingedBirdCommand;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.repository.input.RingedBirdRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RingedBirdServiceImplTest {
    @Mock
    private RingedBirdRepository ringedBirdRepository;

    @Spy
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
    void getAllRingedBirdByCode_Valid_ReturnsList() {
        String ringCode = "R001";

        RingCode codeObject = new RingCode();
        codeObject.setCode(ringCode);

        RingedBird bird1 = new RingedBird();
        bird1.setRingCode(codeObject);
        RingedBird bird2 = new RingedBird();
        bird2.setRingCode(null);
        RingedBird bird3 = new RingedBird();
        bird3.setRingCode(codeObject);
        RingedBird bird4 = new RingedBird();
        bird4.setRingCode(null);


        List<RingedBird> expectedBirds = Arrays.asList(bird1, bird2);

        when(ringedBirdRepository.findAllByRingCode_Code(ringCode)).thenReturn(expectedBirds);

        List<RingedBird> result  = ringedBirdService.getAllRingedBirdByCode(ringCode);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("R001", result.get(0).getRingCode().getCode());
        assertNull(result.get(1).getRingCode());

        verify(ringedBirdRepository, times(1)).findAllByRingCode_Code(ringCode);
    }

    @Test
    void createNewRingedBird_Valid_CreatesNewObject() {
        RingedBirdCommand command = new RingedBirdCommand();
        RingedBird expectedBird = new RingedBird();
        expectedBird.setId(1L);

        when(ringedBirdRepository.findAll()).thenReturn(List.of(expectedBird));

        when(ringedBirdRepository.save(any(RingedBird.class))).thenReturn(expectedBird);

        RingedBird actualBird = ringedBirdService.createNewRingedBird(command);

        assertEquals(expectedBird, actualBird);
        verify(ringedBirdRepository, times(1)).save(any(RingedBird.class));
    }

    @Test
    void createNewRingedBirdFromExisting_ValidRingCode_CreatesAndSavesRingedBird() {
        String ringCode = "R001";

        RingCode codeObject = new RingCode();
        codeObject.setCode(ringCode);

        RingedBirdCommand ringedBirdCommand = new RingedBirdCommand();
        ringedBirdCommand.setRingCode(codeObject);

        RingedBird existingBird = new RingedBird();
        RingedBird secondBird = new RingedBird();
        existingBird.setId(1L);
        existingBird.setRingCode(codeObject);
        secondBird.setId(2L);
        secondBird.setRingCode(codeObject);

        when(ringedBirdRepository.findRingedBirdByReferenceIsNullAndRingCode_Code(ringCode))
                .thenReturn(Optional.of(existingBird));

        RingedBird newBird = new RingedBird();
        newBird.setId(1L);
        newBird.setRingCode(codeObject);
        newBird.setReference(ringCode);

        doNothing().when(ringedBirdService).mapCommandToEntity(any(RingedBirdCommand.class), any(RingedBird.class));
        when(ringedBirdRepository.findAll()).thenReturn(List.of(existingBird, secondBird));
        when(ringedBirdRepository.save(any(RingedBird.class))).thenReturn(newBird);
        when(ringedBirdService.createNewRingedBirdFromExisting(ringCode, ringedBirdCommand)).thenReturn(newBird);

        RingedBird result = ringedBirdService.createNewRingedBirdFromExisting(ringCode, ringedBirdCommand);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(ringCode, result.getRingCode().getCode());
        assertEquals(ringCode, result.getReference());

        verify(ringedBirdRepository, times(1)).findRingedBirdByReferenceIsNullAndRingCode_Code(ringCode);
        verify(ringedBirdService, times(1)).mapCommandToEntity(eq(ringedBirdCommand), any(RingedBird.class));
        verify(ringedBirdService, times(1)).generateMaxId();
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