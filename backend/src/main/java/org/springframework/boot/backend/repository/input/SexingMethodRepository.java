package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.SexingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexingMethodRepository extends JpaRepository<SexingMethod, Long> {
}
