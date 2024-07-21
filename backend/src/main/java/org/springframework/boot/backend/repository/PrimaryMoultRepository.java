package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.PrimaryMoult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryMoultRepository extends JpaRepository<PrimaryMoult, Long> {
}
