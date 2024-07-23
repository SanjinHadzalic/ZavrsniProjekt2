package org.springframework.boot.backend.service.input;


import org.springframework.boot.backend.entity.input.SexingMethod;

import java.util.List;
import java.util.Optional;

public interface SexingMethodService {

    List<SexingMethod> getAllSexingMethods();
    Optional<SexingMethod> getSexingMethodById(Long id);
}
