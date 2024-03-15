package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Bird;
import org.springframework.boot.backend.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BirdServiceImpl implements BirdService {
    private BirdRepository birdRepository;

    @Override
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

}
