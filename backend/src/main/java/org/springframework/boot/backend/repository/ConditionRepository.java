package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
