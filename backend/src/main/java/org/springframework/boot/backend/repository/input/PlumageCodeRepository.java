package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.PlumageCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlumageCodeRepository extends JpaRepository<PlumageCode, Long> {
}
