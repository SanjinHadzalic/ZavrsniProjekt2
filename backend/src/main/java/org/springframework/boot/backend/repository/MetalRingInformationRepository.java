package org.springframework.boot.backend.repository;


import org.springframework.boot.backend.entity.MetalRingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetalRingInformationRepository extends JpaRepository<MetalRingInformation, Long> {
}
