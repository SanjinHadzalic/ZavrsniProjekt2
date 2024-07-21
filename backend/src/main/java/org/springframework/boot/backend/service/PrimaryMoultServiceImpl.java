package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.PrimaryMoult;
import org.springframework.boot.backend.repository.PrimaryMoultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrimaryMoultServiceImpl implements PrimaryMoultService{

    private PrimaryMoultRepository primaryMoultRepository;

    @Override
    public List<PrimaryMoult> getAllPrimaryMoults() {
        return primaryMoultRepository.findAll();
    }

    @Override
    public Optional<PrimaryMoult> getPrimaryMoultById(Long id) {
        return primaryMoultRepository.findById(id);
    }
}