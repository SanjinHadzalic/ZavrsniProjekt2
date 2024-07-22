package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Condition;
import org.springframework.boot.backend.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConditionServiceImpl implements ConditionService{
    private ConditionRepository conditionRepository;
    @Override
    public List<Condition> getAllConditions() {
        return conditionRepository.findAll();
    }

    @Override
    public Optional<Condition> getConditionById(Long id) {
        return conditionRepository.findById(id);
    }
}
