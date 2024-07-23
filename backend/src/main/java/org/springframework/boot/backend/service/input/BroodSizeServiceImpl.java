package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.BroodSize;
import org.springframework.boot.backend.repository.input.BroodSizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BroodSizeServiceImpl implements BroodSizeService{
    private BroodSizeRepository broodSizeRepository;
    @Override
    public List<BroodSize> getAllBroodSizes() {
        return broodSizeRepository.findAll();
    }

    @Override
    public Optional<BroodSize> getBroodSizeById(Long id) {
        return broodSizeRepository.findById(id);
    }
}
