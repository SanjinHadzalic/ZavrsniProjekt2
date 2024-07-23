package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.input.RingingScheme;
import org.springframework.boot.backend.repository.input.RingingSchemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RingingSchemeServiceImpl implements RingingSchemeService{
    private RingingSchemeRepository ringingSchemeRepository;
    @Override
    public List<RingingScheme> getAllRingingSchemes() {
        return ringingSchemeRepository.findAll();
    }

    @Override
    public Optional<RingingScheme> getRingingSchemeById(Long id) {
        return ringingSchemeRepository.findById(id);
    }

    @Override
    public RingingScheme save(RingingScheme ringingScheme) {
        return ringingSchemeRepository.save(ringingScheme);
    }

    @Override
    public RingingScheme update(Long id, RingingScheme ringingScheme) {
        RingingScheme existingRingingScheme = ringingSchemeRepository.getReferenceById(id);

        existingRingingScheme.setCode(ringingScheme.getCode());
        existingRingingScheme.setCountry(ringingScheme.getCountry());
        existingRingingScheme.setCentre(ringingScheme.getCentre());
        existingRingingScheme.setEuring(ringingScheme.getEuring());
        existingRingingScheme.setCurrent(ringingScheme.getCurrent());
        existingRingingScheme.setDateUpdated(ringingScheme.getDateUpdated());
        existingRingingScheme.setNotes(ringingScheme.getNotes());

        return ringingSchemeRepository.save(existingRingingScheme);
    }

    @Override
    public void delete(Long id) {
        ringingSchemeRepository.deleteById(id);
    }
}
