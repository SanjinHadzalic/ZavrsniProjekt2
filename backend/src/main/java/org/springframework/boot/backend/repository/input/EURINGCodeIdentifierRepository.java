package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.EURINGCodeIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EURINGCodeIdentifierRepository extends JpaRepository<EURINGCodeIdentifier, Long> {
}
