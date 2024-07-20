package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.FatScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatScoreRepository extends JpaRepository<FatScore, Long> {
}
