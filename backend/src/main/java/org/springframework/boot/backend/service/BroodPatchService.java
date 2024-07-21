package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.BroodPatch;

import java.util.List;
import java.util.Optional;

public interface BroodPatchService {
    List<BroodPatch> getAllBroodPatches();
    Optional<BroodPatch> getBroodPatchById(Long id);
}
