package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
