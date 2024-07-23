package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.CatchingLures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchingLuresRepository extends JpaRepository<CatchingLures, Long> {
}
