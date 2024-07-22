package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.CatchingLures;
import org.springframework.boot.backend.repository.CatchingLuresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatchingLuresServiceImpl implements CatchingLuresService{
    private CatchingLuresRepository catchingLuresRepository;
    @Override
    public List<CatchingLures> getAllCatchingLures() {
        return catchingLuresRepository.findAll();
    }

    @Override
    public Optional<CatchingLures> getCatchingLuresById(Long id) {
        return catchingLuresRepository.findById(id);
    }
}
