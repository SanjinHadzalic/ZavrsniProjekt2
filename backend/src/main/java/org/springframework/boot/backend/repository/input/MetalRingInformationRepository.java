package org.springframework.boot.backend.repository.input;


import org.springframework.boot.backend.entity.input.MetalRingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetalRingInformationRepository extends JpaRepository<MetalRingInformation, Long> {
}
