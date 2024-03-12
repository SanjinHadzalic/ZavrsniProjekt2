package org.springframework.boot.backend.repository;

import org.springframework.boot.backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
