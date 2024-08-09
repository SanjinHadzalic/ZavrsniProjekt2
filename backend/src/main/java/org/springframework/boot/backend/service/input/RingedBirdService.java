package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.command.RingedBirdCommand;
import org.springframework.boot.backend.entity.input.RingedBird;

import java.util.List;
import java.util.Optional;

public interface RingedBirdService {
    List<RingedBird> getAllRingedBird();
    List<RingedBird> getAllRingedBirdByCode(String code);
    List<RingedBird> getAllRingedBirdOfUser(String username);
    Optional<RingedBird> getRingedBirdByCode(String code);
    Optional<RingedBird> getRingedBirdById(Long id);
    RingedBird createNewRingedBird(RingedBirdCommand ringedBirdCommand);
    RingedBird createNewRingedBirdFromExisting(String ringCode, RingedBirdCommand ringedBirdCommand);
    RingedBird updateRingedBird(Long id, RingedBirdCommand ringedBirdCommand);
    void deleteRingedBirdById(Long id);
}
