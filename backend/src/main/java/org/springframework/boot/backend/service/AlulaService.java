package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Alula;

import java.util.List;
import java.util.Optional;

public interface AlulaService {
    List<Alula> getAllAlulas();
    Optional<Alula> getAlulaById(Long id);
}
