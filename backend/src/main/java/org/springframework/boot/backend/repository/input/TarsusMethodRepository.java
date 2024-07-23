package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.TarsusMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarsusMethodRepository extends JpaRepository<TarsusMethod, Long> {
}
