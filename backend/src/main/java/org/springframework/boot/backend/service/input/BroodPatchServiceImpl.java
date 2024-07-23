package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.BroodPatch;
import org.springframework.boot.backend.repository.input.BroodPatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BroodPatchServiceImpl implements BroodPatchService{

    private BroodPatchRepository broodPatchRepository;

    @Override
    public List<BroodPatch> getAllBroodPatches() {
        return broodPatchRepository.findAll();
    }

    @Override
    public Optional<BroodPatch> getBroodPatchById(Long id) {
        return broodPatchRepository.findById(id);
    }
}
