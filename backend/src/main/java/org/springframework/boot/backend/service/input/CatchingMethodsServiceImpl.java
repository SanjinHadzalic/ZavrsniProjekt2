package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.CatchingMethods;
import org.springframework.boot.backend.repository.input.CatchingMethodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatchingMethodsServiceImpl implements CatchingMethodsService{
    private CatchingMethodsRepository catchingMethodsRepository;
    @Override
    public List<CatchingMethods> getAllCatchingMethods() {
        return catchingMethodsRepository.findAll();
    }

    @Override
    public Optional<CatchingMethods> getCatchingMethodsById(Long id) {
        return catchingMethodsRepository.findById(id);
    }
}
