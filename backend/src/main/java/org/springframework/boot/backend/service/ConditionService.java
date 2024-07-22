package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Condition;

import java.util.List;
import java.util.Optional;

public interface ConditionService {
    List<Condition> getAllConditions();
    Optional<Condition> getConditionById(Long id);
}