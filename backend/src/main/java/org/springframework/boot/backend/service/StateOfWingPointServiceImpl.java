package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.StateOfWingPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StateOfWingPointServiceImpl implements StateOfWingPointService{
    @Override
    public List<StateOfWingPoint> getAllStateOfWingPoint() {
        return null;
    }

    @Override
    public Optional<StateOfWingPoint> getStateOfWingPointById(Long id) {
        return Optional.empty();
    }
}
