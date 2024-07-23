package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.Alula;

import java.util.List;
import java.util.Optional;

public interface AlulaService {
    List<Alula> getAllAlulas();
    Optional<Alula> getAlulaById(Long id);
}
