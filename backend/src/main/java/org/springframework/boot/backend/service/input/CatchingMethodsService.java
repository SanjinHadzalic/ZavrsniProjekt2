package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.CatchingMethods;

import java.util.List;
import java.util.Optional;

public interface CatchingMethodsService {
    List<CatchingMethods> getAllCatchingMethods();
    Optional<CatchingMethods> getCatchingMethodsById(Long id);
}
