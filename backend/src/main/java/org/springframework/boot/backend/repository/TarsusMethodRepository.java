package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.TarsusMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarsusMethodRepository extends JpaRepository<TarsusMethod, Long> {
}
