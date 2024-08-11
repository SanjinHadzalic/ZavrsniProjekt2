package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RingCodeRepository extends JpaRepository<RingCode, Long> {
    List<RingCode> getRingCodesByAppUser_UsernameAndAppUser_Email(String username, String email);
    Optional<RingCode> getRingCodeByCode(String code);
}
