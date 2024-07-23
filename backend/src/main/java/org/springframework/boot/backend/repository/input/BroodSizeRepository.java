package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.BroodSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroodSizeRepository extends JpaRepository<BroodSize, Long> {
}
