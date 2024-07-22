package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository extends JpaRepository<Sex, Long> {
}
