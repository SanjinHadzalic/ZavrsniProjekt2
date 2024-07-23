package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.BillMethod;

import java.util.List;
import java.util.Optional;

public interface BillMethodService {
    List<BillMethod> getAllBillMethods();
    Optional<BillMethod> getBillMethodById(Long id);
}
