package org.springframework.boot.backend.service;

import org.springframework.boot.backend.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    List<Status> getAllStatuses();
    Optional<Status> getStatusById(Long id);
}
