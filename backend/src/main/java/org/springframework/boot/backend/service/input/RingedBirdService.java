package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.command.RingedBirdCommand;
import org.springframework.boot.backend.entity.input.RingedBird;

import java.util.List;
import java.util.Optional;

public interface RingedBirdService {
    List<RingedBird> getAllRingedBird();
    Optional<RingedBird> getRingedBirdById(Long id);
    RingedBird createNewRingedBird(RingedBirdCommand ringedBirdCommand);
    RingedBird updateRingedBird(Long id, RingedBirdCommand ringedBirdCommand);
    void deleteRingedBirdById(Long id);
}
