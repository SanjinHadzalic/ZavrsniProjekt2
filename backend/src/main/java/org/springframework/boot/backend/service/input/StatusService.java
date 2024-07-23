package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    List<Status> getAllStatuses();
    Optional<Status> getStatusById(Long id);
}
