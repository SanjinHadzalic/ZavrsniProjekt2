package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.AccuracyOfDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccuracyOfDateRepository extends JpaRepository<AccuracyOfDate, Long> {
}
