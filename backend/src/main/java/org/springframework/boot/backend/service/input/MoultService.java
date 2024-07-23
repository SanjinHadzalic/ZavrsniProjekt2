package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.Moult;

import java.util.List;
import java.util.Optional;

public interface MoultService {
    List<Moult> getAllMoults();
    Optional<Moult> getMoultById(Long id);
}
