package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Bird;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BirdRepository extends JpaRepository<Bird, Long> {
}
