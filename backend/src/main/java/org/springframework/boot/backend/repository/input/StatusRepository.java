package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
