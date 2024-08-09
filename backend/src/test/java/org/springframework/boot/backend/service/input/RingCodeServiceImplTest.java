package org.springframework.boot.backend.service.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.backend.entity.command.RingCodeCommand;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.boot.backend.repository.input.RingCodeRepository;
import org.springframework.boot.backend.service.jwt.UserDetailsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class RingCodeServiceImplTest {
    @Mock
    private RingCodeRepository ringCodeRepository;
    @Mock
    private UserDetailsServiceImpl userDetailsService;
    @InjectMocks
    private RingCodeServiceImpl ringCodeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllRingCodes_Valid_ReturnsAll() {
        List<RingCode> ringCodes = new ArrayList<>();
        RingCode ringCode1 = new RingCode();
        ringCode1.setId(1L);
        ringCode1.setCode("BJ001");

        RingCode ringCode2 = new RingCode();
        ringCode2.setId(2L);
        ringCode2.setCode("BJ002");

        ringCodes.add(ringCode1);
        ringCodes.add(ringCode2);

        when(ringCodeRepository.findAll()).thenReturn(ringCodes);

        List<RingCode> result = ringCodeService.getAllRingCodes();

        assertEquals(2, result.size());
        verify(ringCodeRepository, times(1)).findAll();
    }

    @Test
    public void GetRingCodeById_Valid_ReturnsCorrectObject() {
        RingCode ringCode = new RingCode();
        ringCode.setId(1L);
        ringCode.setCode("BJ001");

        when(ringCodeRepository.findById(1L)).thenReturn(Optional.of(ringCode));

        Optional<RingCode> result = ringCodeService.getRingCodeById(1L);

        assertTrue(result.isPresent());
        assertEquals("BJ001", result.get().getCode());
        verify(ringCodeRepository, times(1)).findById(1L);
    }

    @Test
    public void GenerateNewRingCode_Valid_ReturnsNewObject() {
        String username = "testUser";
        String starter = "BJ";
        int range = 5;
        String codePrefix = "BJ";

        ApplicationUser appUser = new ApplicationUser();
        appUser.setUsername(username);

        List<RingCode> existingRingCodes = new ArrayList<>();
        RingCode existingRingCode1 = new RingCode();
        existingRingCode1.setCode("BJ001");
        existingRingCodes.add(existingRingCode1);

        RingCode existingRingCode2 = new RingCode();
        existingRingCode2.setCode("BJ002");
        existingRingCodes.add(existingRingCode2);

        when(userDetailsService.findApplicationUserByUsername(username)).thenReturn(appUser);

        when(ringCodeRepository.findAll()).thenReturn(existingRingCodes);
        when(ringCodeRepository.saveAll(any())).thenAnswer(i -> i.getArguments()[0]);

        List<RingCode> result = ringCodeService.generateNewRingCode(username, codePrefix, range);

        assertEquals(3, result.size());

        assertEquals("BJ003", result.get(0).getCode());
        assertEquals("BJ004", result.get(1).getCode());
        assertEquals("BJ005", result.get(2).getCode());

        result.forEach(ringCode -> assertEquals(username, ringCode.getAppUser().getUsername()));

        verify(ringCodeRepository, times(1)).findAll();
        verify(ringCodeRepository, times(1)).saveAll(any());
    }
    @Test
    public void UpdateRingCode_Valid_ReturnsUpdatedObject() {
        RingCode existingRingCode = new RingCode();
        existingRingCode.setId(1L);
        existingRingCode.setCode("BJ001");
        ApplicationUser appUser = new ApplicationUser();
        appUser.setId(1L);
        existingRingCode.setAppUser(appUser);

        RingCodeCommand ringCodeCommand = new RingCodeCommand();
        ringCodeCommand.setCode("BJ002");
        ringCodeCommand.setAppUser(appUser);

        when(ringCodeRepository.findById(1L)).thenReturn(Optional.of(existingRingCode));
        when(ringCodeRepository.save(any(RingCode.class))).thenReturn(existingRingCode);

        RingCode result = ringCodeService.updateRingCode(1L, ringCodeCommand);

        assertEquals("BJ002", result.getCode());
        assertEquals(1L, result.getAppUser().getId());
        verify(ringCodeRepository, times(1)).findById(1L);
        verify(ringCodeRepository, times(1)).save(any(RingCode.class));
    }

    @Test
    public void DeleteRingCodeById_Valid_RemovesObjectById() {
        RingCode ringCode = new RingCode();
        ringCode.setId(1L);
        ringCode.setCode("BJ001");

        when(ringCodeRepository.findById(1L)).thenReturn(Optional.of(ringCode));
        doNothing().when(ringCodeRepository).deleteById(1L);

        ringCodeService.deleteRingCodeById(1L);

        verify(ringCodeRepository, times(1)).findById(1L);
        verify(ringCodeRepository, times(1)).deleteById(1L);
    }
}