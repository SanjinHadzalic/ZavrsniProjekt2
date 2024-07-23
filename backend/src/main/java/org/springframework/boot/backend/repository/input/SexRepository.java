package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository extends JpaRepository<Sex, Long> {
}
