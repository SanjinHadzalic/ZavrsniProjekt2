package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Age;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRepository extends JpaRepository<Age, Long> {
}
