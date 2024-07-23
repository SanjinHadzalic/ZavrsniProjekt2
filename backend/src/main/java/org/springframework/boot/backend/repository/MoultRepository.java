package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Moult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoultRepository extends JpaRepository<Moult, Long> {
}
