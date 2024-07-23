package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.CarpalCovert;
import org.springframework.boot.backend.repository.input.CarpalCovertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarpalCovertServiceImpl implements CarpalCovertService{

    private CarpalCovertRepository carpalCovertRepository;

    @Override
    public List<CarpalCovert> getAllCarpalCoverts() {
        return carpalCovertRepository.findAll();
    }

    @Override
    public Optional<CarpalCovert> getCarpalCovertById(Long id) {
        return carpalCovertRepository.findById(id);
    }
}
