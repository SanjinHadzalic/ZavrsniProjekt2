package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.BillMethod;
import org.springframework.boot.backend.repository.BillMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BillMethodServiceImpl implements BillMethodService{
    private BillMethodRepository billMethodRepository;
    @Override
    public List<BillMethod> getAllBillMethods() {
        return billMethodRepository.findAll();
    }

    @Override
    public Optional<BillMethod> getBillMethodById(Long id) {
        return billMethodRepository.findById(id);
    }
}
