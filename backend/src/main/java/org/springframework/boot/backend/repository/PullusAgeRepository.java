package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.PullusAge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PullusAgeRepository extends JpaRepository<PullusAge, Long> {
}
