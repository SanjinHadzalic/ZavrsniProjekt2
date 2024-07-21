package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.SexingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexingMethodRepository extends JpaRepository<SexingMethod, Long> {
}
