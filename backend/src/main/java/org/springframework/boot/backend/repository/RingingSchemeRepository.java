package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.RingingScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RingingSchemeRepository extends JpaRepository<RingingScheme, Long> {
}
