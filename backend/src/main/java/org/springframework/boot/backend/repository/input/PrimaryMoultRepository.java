package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.PrimaryMoult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryMoultRepository extends JpaRepository<PrimaryMoult, Long> {
}
