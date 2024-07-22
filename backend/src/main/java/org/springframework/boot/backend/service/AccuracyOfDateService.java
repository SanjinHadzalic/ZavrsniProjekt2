package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.AccuracyOfDate;

import java.util.List;
import java.util.Optional;

public interface AccuracyOfDateService {
    List<AccuracyOfDate> getAllAccuracyOfDates();
    Optional<AccuracyOfDate> getAccuracyOfDateById(Long id);
}
