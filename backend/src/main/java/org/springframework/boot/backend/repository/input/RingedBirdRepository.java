package org.springframework.boot.backend.repository.input;

import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RingedBirdRepository extends JpaRepository<RingedBird, Long> {
    Optional<RingedBird> findRingedBirdByReferenceIsNullAndRingCode_Code(String ringCode);
    List<RingedBird> findAllByRingCode_AppUser_Username(String username);
    List<RingedBird> findAllByRingCode_Code(String ringCode);
    Boolean existsRingedBirdByRingCode_Code(String ringCode);
    @Query("SELECT rb FROM RingedBird rb WHERE " +
            "(:ringCode IS NULL OR rb.ringCode.code = :ringCode) " +
            "AND (:date IS NULL OR rb.date = :date) " +
            "AND (:country IS NULL OR rb.placeCode.country = :country) " +
            "AND (:year IS NULL OR FUNCTION('YEAR', rb.date) = :year) " +
            "AND (:month IS NULL OR FUNCTION('MONTH', rb.date) = :month) " +
            "AND (:placeCode IS NULL OR LOWER(rb.placeCode.name) LIKE LOWER(CONCAT('%', :placeCode, '%'))) " + // Convert to lowercase
            "AND (:username IS NULL OR rb.ringCode.appUser.username = :username) " +
            "AND (:sex IS NULL OR rb.sex = :sex) " +
            "AND (:age IS NULL OR rb.age = :age) " +
            "AND (:species IS NULL OR rb.species.commonName LIKE CONCAT('%', :species, '%'))")
    List<RingedBird> findByCriteria(
            @Param("ringCode") String ringCode,
            @Param("date") LocalDate date,
            @Param("country") String country,
            @Param("year") Integer year, // Use Integer for year
            @Param("month") Integer month, // Use Integer for month
            @Param("placeCode") String placeCode,
            @Param("username") String username,
            @Param("sex") String sex,
            @Param("age") String age,
            @Param("species") String species // Move this parameter inside the method signature
    );
}
