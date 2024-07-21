package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Alula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlulaRepository extends JpaRepository<Alula, Long> {
}
