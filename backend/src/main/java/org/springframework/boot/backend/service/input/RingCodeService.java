package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.RingCode;

import java.util.List;
import java.util.Optional;

public interface RingCodeService {
    List<RingCode> getAllRingCodes();
    Optional<RingCode> getRingCodeById(Long id);
    List<RingCode> generateNewRingCode(String code, Integer range, String starter);
    RingCode updateRingCode(Long id, RingCode toBeUpdated);
    void deleteRingCodeById(Long id);
}
