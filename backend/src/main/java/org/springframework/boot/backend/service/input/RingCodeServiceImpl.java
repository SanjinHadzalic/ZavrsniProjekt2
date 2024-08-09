package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.command.RingCodeCommand;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.boot.backend.repository.input.RingCodeRepository;
import org.springframework.boot.backend.service.jwt.UserDetailsServiceImpl;
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
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public List<RingCode> getAllRingCodes() {
        return ringCodeRepository.findAll();
    }

    @Override
    public List<RingCode> getAllRingCodeByUsernameAndEmail(String username, String email) {
        return ringCodeRepository.getRingCodesByAppUser_UsernameAndAppUser_Email(username, email);
    }

    @Override
    public Optional<RingCode> getRingCodeById(Long id) {
        return ringCodeRepository.findById(id);
    }

    @Override
    public List<RingCode> generateNewRingCode(String username, String code, Integer range) {
        ApplicationUser appUser = userDetailsService.findApplicationUserByUsername(username);

        List<RingCode> existingRingCodes = getAllRingCodes();
        Set<String> existingCodes = existingRingCodes.stream()
                .map(RingCode::getCode)
                .collect(Collectors.toSet());

        List<RingCode> newCodes = new ArrayList<>();
        List<String> duplicateCodes = new ArrayList<>();

        Optional<String> latestRingCode = existingRingCodes.stream()
                .map(RingCode::getCode)
                .filter(c -> c.startsWith(code))
                .reduce((first, second) -> first.compareTo(second) > 0 ? first : second);

        // Determine the starting number for new ring codes
        int startNumber = 0;  // Default starting number if no existing codes found
        if (latestRingCode.isPresent()) {
            String latestCode = latestRingCode.get();
            // Extract the numeric part of the latest code
            String numberPart = latestCode.substring(2); // Assuming the first character is "R"
            startNumber = Integer.parseInt(numberPart); // Convert to integer
        }

        // Generate new ring codes based on the latest code
        for (int i = 1; i <= range; i++) {
            RingCode newRingCode = new RingCode();
            String newCode = String.format("R%03d", startNumber + i); // Start from the latest number + i
            newRingCode.setCode(newCode);
            newRingCode.setAppUser(appUser);
            if (!existingCodes.contains(newCode)) {
                newCodes.add(newRingCode);
            } else {
                duplicateCodes.add(newCode);
                System.out.println("Code already exists: " + duplicateCodes);
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
