package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.BroodSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroodSizeRepository extends JpaRepository<BroodSize, Long> {
}
