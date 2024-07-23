package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
