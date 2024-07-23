package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.EURINGCodeIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EURINGCodeIdentifierRepository extends JpaRepository<EURINGCodeIdentifier, Long> {
}
