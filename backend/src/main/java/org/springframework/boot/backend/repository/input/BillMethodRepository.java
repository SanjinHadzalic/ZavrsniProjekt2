package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.BillMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillMethodRepository extends JpaRepository<BillMethod, Long> {
}
