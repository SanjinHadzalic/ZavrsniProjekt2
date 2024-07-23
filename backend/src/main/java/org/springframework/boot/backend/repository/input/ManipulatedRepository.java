package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Manipulated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManipulatedRepository extends JpaRepository<Manipulated, Long> {
}
