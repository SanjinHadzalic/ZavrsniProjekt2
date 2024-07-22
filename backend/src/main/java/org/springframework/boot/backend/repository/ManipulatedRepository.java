package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Manipulated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManipulatedRepository extends JpaRepository<Manipulated, Long> {
}
