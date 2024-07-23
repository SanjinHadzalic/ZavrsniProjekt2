package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.PrimaryIdentificationMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryIdentificationMethodRepository extends JpaRepository<PrimaryIdentificationMethod, Long> {
}
