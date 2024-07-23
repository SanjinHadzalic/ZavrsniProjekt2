package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.PlumageCode;

import java.util.List;
import java.util.Optional;

public interface PlumageCodeService {
    List<PlumageCode> getAllPlumageCodes();
    Optional<PlumageCode> getPlumageCodeById(Long id);
}
