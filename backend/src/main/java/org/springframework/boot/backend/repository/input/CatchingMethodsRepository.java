package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.CatchingMethods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchingMethodsRepository extends JpaRepository<CatchingMethods, Long> {
}
