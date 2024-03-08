package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BirdRepository extends JpaRepository<Bird, Long> {
}
