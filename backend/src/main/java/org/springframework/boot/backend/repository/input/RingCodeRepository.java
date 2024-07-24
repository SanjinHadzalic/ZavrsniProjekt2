package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RingCodeRepository extends JpaRepository<RingCode, Long> {
}
