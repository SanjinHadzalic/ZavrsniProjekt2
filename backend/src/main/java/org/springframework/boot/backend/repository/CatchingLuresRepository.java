package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.CatchingLures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchingLuresRepository extends JpaRepository<CatchingLures, Long> {
}
