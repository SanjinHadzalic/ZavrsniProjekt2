package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.CatchingLures;

import java.util.List;
import java.util.Optional;

public interface CatchingLuresService {
    List<CatchingLures> getAllCatchingLures();
    Optional<CatchingLures> getCatchingLuresById(Long id);
}
