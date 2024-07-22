package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Manipulated;

import java.util.List;
import java.util.Optional;

public interface ManipulatedService {
    List<Manipulated> getAllManipulated();
    Optional<Manipulated> getManipulatedById(Long id);
}
