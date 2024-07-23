package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.PrimaryMoult;

import java.util.List;
import java.util.Optional;

public interface PrimaryMoultService {
    List<PrimaryMoult> getAllPrimaryMoults();
    Optional<PrimaryMoult> getPrimaryMoultById(Long id);
}
