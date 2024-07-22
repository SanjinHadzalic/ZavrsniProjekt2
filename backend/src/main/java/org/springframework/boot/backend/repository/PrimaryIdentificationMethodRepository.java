package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.PrimaryIdentificationMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryIdentificationMethodRepository extends JpaRepository<PrimaryIdentificationMethod, Long> {
}
