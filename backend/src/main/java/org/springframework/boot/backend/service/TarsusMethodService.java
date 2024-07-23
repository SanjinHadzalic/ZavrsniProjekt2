package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.TarsusMethod;

import java.util.List;
import java.util.Optional;

public interface TarsusMethodService {
    List<TarsusMethod> getAllTarsusMethods();
    Optional<TarsusMethod> getTarsusMethodById(Long id);
}
