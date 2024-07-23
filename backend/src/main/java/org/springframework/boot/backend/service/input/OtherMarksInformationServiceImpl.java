package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.OtherMarksInformation;
import org.springframework.boot.backend.repository.input.OtherMarksInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OtherMarksInformationServiceImpl implements OtherMarksInformationService{
    private OtherMarksInformationRepository otherMarksInformationRepository;
    @Override
    public List<OtherMarksInformation> getAllOtherMarksInformation() {
        return otherMarksInformationRepository.findAll();
    }

    @Override
    public Optional<OtherMarksInformation> getOtherMarksInformationById(Long id) {
        return otherMarksInformationRepository.findById(id);
    }
}
