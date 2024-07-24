package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RingedBirdRepository extends JpaRepository<RingedBird, Long> {
}
