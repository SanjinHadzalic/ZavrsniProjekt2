package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.CatchingMethods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchingMethodsRepository extends JpaRepository<CatchingMethods, Long> {
}
