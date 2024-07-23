package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.PullusAge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PullusAgeRepository extends JpaRepository<PullusAge, Long> {
}
