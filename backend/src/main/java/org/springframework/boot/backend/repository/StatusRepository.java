package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
