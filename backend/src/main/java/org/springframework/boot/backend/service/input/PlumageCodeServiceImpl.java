package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.PlumageCode;
import org.springframework.boot.backend.repository.input.PlumageCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlumageCodeServiceImpl implements PlumageCodeService{
    private PlumageCodeRepository plumageCodeRepository;
    @Override
    public List<PlumageCode> getAllPlumageCodes() {
        return plumageCodeRepository.findAll();
    }

    @Override
    public Optional<PlumageCode> getPlumageCodeById(Long id) {
        return plumageCodeRepository.findById(id);
    }
}
