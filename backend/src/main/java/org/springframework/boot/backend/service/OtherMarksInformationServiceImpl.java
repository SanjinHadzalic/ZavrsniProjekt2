package org.springframework.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.OtherMarksInformation;
import org.springframework.boot.backend.repository.OtherMarksInformationRepository;
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
