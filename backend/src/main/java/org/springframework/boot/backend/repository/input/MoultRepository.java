package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Moult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoultRepository extends JpaRepository<Moult, Long> {
}
