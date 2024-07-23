package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Age;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRepository extends JpaRepository<Age, Long> {
}
