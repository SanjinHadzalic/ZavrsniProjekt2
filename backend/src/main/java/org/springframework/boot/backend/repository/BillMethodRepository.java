package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.BillMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillMethodRepository extends JpaRepository<BillMethod, Long> {
}
