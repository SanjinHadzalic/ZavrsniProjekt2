package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.BroodPatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroodPatchRepository extends JpaRepository<BroodPatch, Long> {
}
