package org.springframework.boot.backend.repository.jwt;

import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);
    Boolean existsByUsernameAndEmail(String username, String email);
}
