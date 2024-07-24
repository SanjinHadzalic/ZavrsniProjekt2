package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.repository.input.RingCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RingCodeServiceImpl implements RingCodeService{
    private RingCodeRepository ringCodeRepository;
    @Override
    public List<RingCode> getAllRingCodes() {
        return ringCodeRepository.findAll();
    }

    @Override
    public Optional<RingCode> getRingCodeById(Long id) {
        return ringCodeRepository.findById(id);
    }
}
