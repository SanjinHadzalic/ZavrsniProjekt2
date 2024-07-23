package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.BroodSize;

import java.util.List;
import java.util.Optional;

public interface BroodSizeService {
    List<BroodSize> getAllBroodSizes();
    Optional<BroodSize> getBroodSizeById(Long id);
}
