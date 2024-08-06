package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RingedBirdRepository extends JpaRepository<RingedBird, Long> {
    Optional<RingedBird> findRingedBirdByReferenceIsNullAndRingCode_Code(String ringCode);
    List<RingedBird> findAllByRingCode_Code(String ringCode);
}
