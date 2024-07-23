package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.TarsusMethod;
import org.springframework.boot.backend.repository.input.TarsusMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarsusMethodServiceImpl implements TarsusMethodService{
    private TarsusMethodRepository tarsusMethodRepository;
    @Override
    public List<TarsusMethod> getAllTarsusMethods() {
        return tarsusMethodRepository.findAll();
    }

    @Override
    public Optional<TarsusMethod> getTarsusMethodById(Long id) {
        return tarsusMethodRepository.findById(id);
    }
}
