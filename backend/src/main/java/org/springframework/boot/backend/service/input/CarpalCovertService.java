package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.CarpalCovert;

import java.util.List;
import java.util.Optional;

public interface CarpalCovertService {
    List<CarpalCovert> getAllCarpalCoverts();
    Optional<CarpalCovert> getCarpalCovertById(Long id);
}
