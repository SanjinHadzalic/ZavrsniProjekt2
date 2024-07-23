package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.Alula;
import org.springframework.boot.backend.repository.input.AlulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlulaServiceImpl implements AlulaService{

    private AlulaRepository alulaRepository;

    @Override
    public List<Alula> getAllAlulas() {
        return alulaRepository.findAll();
    }

    @Override
    public Optional<Alula> getAlulaById(Long id) {
        return alulaRepository.findById(id);
    }
}
