package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.RingingScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RingingSchemeRepository extends JpaRepository<RingingScheme, Long> {
}
