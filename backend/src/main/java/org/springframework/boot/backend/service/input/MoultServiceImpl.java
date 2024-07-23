package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.Moult;
import org.springframework.boot.backend.repository.input.MoultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoultServiceImpl implements MoultService{
    private MoultRepository moultRepository;
    @Override
    public List<Moult> getAllMoults() {
        return moultRepository.findAll();
    }

    @Override
    public Optional<Moult> getMoultById(Long id) {
        return moultRepository.findById(id);
    }
}
