package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.BroodPatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroodPatchRepository extends JpaRepository<BroodPatch, Long> {
}
