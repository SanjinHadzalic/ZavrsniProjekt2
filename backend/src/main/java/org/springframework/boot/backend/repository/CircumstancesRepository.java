package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Circumstances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircumstancesRepository extends JpaRepository<Circumstances, Long> {
}
