package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.FatScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatScoreRepository extends JpaRepository<FatScore, Long> {
}
