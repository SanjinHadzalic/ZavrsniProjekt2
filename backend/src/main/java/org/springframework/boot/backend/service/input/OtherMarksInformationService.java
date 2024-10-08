package org.springframework.boot.backend.service.input;

import org.springframework.boot.backend.entity.input.OtherMarksInformation;

import java.util.List;
import java.util.Optional;

public interface OtherMarksInformationService {
    List<OtherMarksInformation> getAllOtherMarksInformation();
    Optional<OtherMarksInformation> getOtherMarksInformationById(Long id);
}
