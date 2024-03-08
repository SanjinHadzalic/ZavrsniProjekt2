package org.springframework.boot.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.backend.entity.Bird;
import org.springframework.boot.backend.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdServiceImpl implements BirdService {
    @Autowired
    private BirdRepository birdRepository;

    @Override
    public List<Bird> getAllBirds() {
        return birdRepository.findAll();
    }

}
