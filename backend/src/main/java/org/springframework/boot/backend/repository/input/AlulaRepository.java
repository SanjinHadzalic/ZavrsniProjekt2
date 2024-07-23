package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Alula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlulaRepository extends JpaRepository<Alula, Long> {
}
