package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.PlumageCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlumageCodeRepository extends JpaRepository<PlumageCode, Long> {
}
