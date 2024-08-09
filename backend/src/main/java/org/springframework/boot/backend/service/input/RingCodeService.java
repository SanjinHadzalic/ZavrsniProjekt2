package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.command.RingCodeCommand;
import org.springframework.boot.backend.entity.input.RingCode;

import java.util.List;
import java.util.Optional;

public interface RingCodeService {
    List<RingCode> getAllRingCodes();
    List<RingCode> getAllRingCodeByUsernameAndEmail(String username, String email);
    List<RingCode> getAllAvailableRingCodes();
    Optional<RingCode> getRingCodeById(Long id);
    List<RingCode> generateNewRingCode(String username, String code, Integer range);
    RingCode updateRingCode(Long id, RingCodeCommand toBeUpdated);
    void deleteRingCodeById(Long id);
}
