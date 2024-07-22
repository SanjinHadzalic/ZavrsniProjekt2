package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.Status;
import org.springframework.boot.backend.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService{
    private StatusRepository statusRepository;
    @Override
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> getStatusById(Long id) {
        return statusRepository.findById(id);
    }
}
