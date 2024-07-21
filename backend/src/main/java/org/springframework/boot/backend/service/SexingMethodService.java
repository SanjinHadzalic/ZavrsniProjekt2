package org.springframework.boot.backend.service;


import org.springframework.boot.backend.entity.SexingMethod;

import java.util.List;
import java.util.Optional;

public interface SexingMethodService {

    List<SexingMethod> getAllSexingMethods();
    Optional<SexingMethod> getSexingMethodById(Long id);
}
