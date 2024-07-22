package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.CatchingLures;

import java.util.List;
import java.util.Optional;

public interface CatchingLuresService {
    List<CatchingLures> getAllCatchingLures();
    Optional<CatchingLures> getCatchingLuresById(Long id);
}
