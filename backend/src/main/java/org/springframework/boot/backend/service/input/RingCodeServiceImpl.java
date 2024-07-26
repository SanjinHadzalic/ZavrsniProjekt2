package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.command.RingCodeCommand;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.entity.user.AppUser;
import org.springframework.boot.backend.repository.input.RingCodeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RingCodeServiceImpl implements RingCodeService {
    private RingCodeRepository ringCodeRepository;

    @Override
    public List<RingCode> getAllRingCodes() {
        return ringCodeRepository.findAll();
    }

    @Override
    public Optional<RingCode> getRingCodeById(Long id) {
        return ringCodeRepository.findById(id);
    }

    @Override
    public List<RingCode> generateNewRingCode(String code, Integer range, String starter) {
        AppUser appUser = new AppUser(); // TODO treba dohvacati Usera iz JWOT tokena
        appUser.setId(1L);
        // provjeriti postoji li jedan od kodova u seriji vec u tablici "ring_code"
        List<RingCode> exisitingRingCodes = getAllRingCodes();
        Set<String> existingCodes = exisitingRingCodes.stream()
                .map(RingCode::getCode)
                .collect(Collectors.toSet());

        List<RingCode> newCodes = new ArrayList<>();
        List<String> duplicateCodes = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            RingCode newRingCode = new RingCode();
            String newCode = String.format("%s%03d", starter, i);
            newRingCode.setCode(newCode);
            newRingCode.setAppUser(appUser);
            if (!existingCodes.contains(newCode)) {
                newCodes.add(newRingCode);
            } else {
                duplicateCodes.add(newCode);
                System.out.println("Code already exists " + duplicateCodes);
            }
        }


        return ringCodeRepository.saveAll(newCodes);
    }

    @Override
    public RingCode updateRingCode(Long id, RingCodeCommand toBeUpdated) {
        Optional<RingCode> existingRingCodeOpt = ringCodeRepository.findById(id);
        RingCode existingRingCode = existingRingCodeOpt.get();

        if (existingRingCodeOpt.isPresent()) {
            existingRingCode.setCode(toBeUpdated.getCode());
            existingRingCode.setAppUser(toBeUpdated.getAppUser());

            return ringCodeRepository.save(existingRingCode);
        } else {
            throw new RuntimeException("RingCode not found with id= " + id);
        }
    }

    @Override
    public void deleteRingCodeById(Long id) {
        Optional<RingCode> ringCodeOpt = ringCodeRepository.findById(id);

        if (ringCodeOpt.isPresent()) {
            ringCodeRepository.deleteById(id);
        } else {
            throw new RuntimeException("RingCode with id= " + " not found!");
        }
    }
}
