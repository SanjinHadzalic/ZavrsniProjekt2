package org.springframework.boot.backend.service.input;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.command.RingedBirdCommand;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.repository.input.RingedBirdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RingedBirdServiceImpl implements RingedBirdService{
    private RingedBirdRepository ringedBirdRepository;
    @Override
    public List<RingedBird> getAllRingedBird() {
        return ringedBirdRepository.findAll();
    }

    public List<RingedBird> getRingedBirdsByCriteria(
            String ringCode,
            LocalDate date,
            String country,
            Integer year,
            Integer month,
            String placeCode,
            String username,
            String sex,
            String age,
            String species) {

        // Check and set parameters to null if blank or invalid
        if (ringCode != null && ringCode.isBlank()) {
            ringCode = null;
        }
        if (country != null && country.isBlank()) {
            country = null;
        }
        if (placeCode != null && placeCode.isBlank()) {
            placeCode = null;
        }
        if (username != null && username.isBlank()) {
            username = null;
        }
        if (species != null && species.isBlank()) {
            species = null;
        }
        if (sex != null && sex.isBlank()) {
            sex = null;
        }
        if (age != null && age.isBlank()) {
            age = null;
        }

        return ringedBirdRepository.findByCriteria(ringCode, date, country, year, month, placeCode, username, sex, age, species);
    }


    @Override
    public List<RingedBird> getAllRingedBirdByCode(String code) {
        return ringedBirdRepository.findAllByRingCode_Code(code);
    }

    @Override
    public List<RingedBird> getAllRingedBirdOfUser(String username) {
        List<RingedBird> allRingedBirds = ringedBirdRepository.findAll();
        List<RingedBird> ringedBirdsByUser = allRingedBirds.stream()
                .filter(ringedBird -> ringedBird.getRingCode() != null &&
                        ringedBird.getRingCode().getAppUser() != null &&
                        username.equals(ringedBird.getRingCode().getAppUser().getUsername()))
                .collect(Collectors.toList());

        return ringedBirdsByUser;
    }

    @Override
    public Optional<RingedBird> getRingedBirdByCode(String code) {
        return ringedBirdRepository.findRingedBirdByReferenceIsNullAndRingCode_Code(code);
    }

    @Override
    public Optional<RingedBird> getRingedBirdById(Long id) {
        return ringedBirdRepository.findById(id);
    }

    @Override
    public RingedBird createNewRingedBird(RingedBirdCommand ringedBirdCommand) {
        RingedBird ringedBird = new RingedBird();
        ringedBird.setId(generateMaxId());
        mapCommandToEntity(ringedBirdCommand, ringedBird);

        return ringedBirdRepository.save(ringedBird);
    }

    @Override
    public RingedBird updateRingedBird(Long id, RingedBirdCommand ringedBirdCommand) {
        Optional<RingedBird> existingRingedBirdOpt = ringedBirdRepository.findById(id);
        if (existingRingedBirdOpt.isPresent()) {
            RingedBird ringedBird = existingRingedBirdOpt.get();
            mapCommandToEntity(ringedBirdCommand, ringedBird);

            return ringedBirdRepository.save(ringedBird);
        } else {
            throw new RuntimeException("RingedBird not found with id= " + id);
        }
    }

    @Override
    public void deleteRingedBirdById(Long id) {
        ringedBirdRepository.deleteById(id);
    }

    @Override
    public RingedBird createNewRingedBirdFromExisting(String ringCode, RingedBirdCommand ringedBirdCommand) {
        Optional<RingedBird> ringedBirdOpt = ringedBirdRepository.findRingedBirdByReferenceIsNullAndRingCode_Code(ringCode);

        if (ringedBirdOpt.isPresent()) {
            RingedBird ringedBirdRaw = ringedBirdOpt.get();
            RingedBird toBeSaved = new RingedBird();
            mapCommandToEntity(ringedBirdCommand, toBeSaved);

            toBeSaved.setId(generateMaxId());
            toBeSaved.setRingCode(ringedBirdRaw.getRingCode());
            toBeSaved.setReference(ringedBirdRaw.getRingCode().getCode());

            return ringedBirdRepository.save(toBeSaved);
        } else {
            throw new RuntimeException("RingedBird not found with ringCode= " + ringCode);
        }
    }

    public Long generateMaxId() {
        return getAllRingedBird().stream().map(RingedBird::getId).max(Long::compare).get() + 1L;
    }

    public void mapCommandToEntity(RingedBirdCommand ringedBirdCommand, RingedBird ringedBird) {
        ringedBird.setRingingScheme(ringedBirdCommand.getRingingScheme());
        ringedBird.setPrimaryIdentificationMethod(ringedBirdCommand.getPrimaryIdentificationMethod());
        ringedBird.setRingCode(ringedBirdCommand.getRingCode());
        ringedBird.setVerificationOfTheMetalRing(ringedBirdCommand.getVerificationOfTheMetalRing());
        ringedBird.setMetalRingInformation(ringedBirdCommand.getMetalRingInformation());
        ringedBird.setOtherMarksInformation(ringedBirdCommand.getOtherMarksInformation());
        ringedBird.setSpecies(ringedBirdCommand.getSpecies());
        ringedBird.setManipulated(ringedBirdCommand.getManipulated());
        ringedBird.setMovedBeforeTheEncounter(ringedBirdCommand.getMovedBeforeTheEncounter());
        ringedBird.setCatchingMethods(ringedBirdCommand.getCatchingMethods());
        ringedBird.setCatchingLures(ringedBirdCommand.getCatchingLures());
        ringedBird.setSex(ringedBirdCommand.getSex());
        ringedBird.setAge(ringedBirdCommand.getAge());
        ringedBird.setStatus(ringedBirdCommand.getStatus());
        ringedBird.setBroodSize(ringedBirdCommand.getBroodSize());
        ringedBird.setPullusAge(ringedBirdCommand.getPullusAge());
        ringedBird.setAccuracyOfPullusAge(ringedBirdCommand.getAccuracyOfPullusAge());
        ringedBird.setDate(ringedBirdCommand.getDate());
        ringedBird.setAccuracyOfDate(ringedBirdCommand.getAccuracyOfDate());
        ringedBird.setTime(ringedBirdCommand.getTime());
        ringedBird.setPlaceCode(ringedBirdCommand.getPlaceCode());
        ringedBird.setCondition(ringedBirdCommand.getCondition());
        ringedBird.setCircumstances(ringedBirdCommand.getCircumstances());
        ringedBird.setEuringCodeIdentifier(ringedBirdCommand.getEuringCodeIdentifier());
        ringedBird.setDerivedDataDistance(ringedBirdCommand.getDerivedDataDistance());
        ringedBird.setDerivedDataDirection(ringedBirdCommand.getDerivedDataDirection());
        ringedBird.setDerivedDataElapsedTime(ringedBirdCommand.getDerivedDataElapsedTime());
        ringedBird.setWingLength(ringedBirdCommand.getWingLength());
        ringedBird.setThirdPrimary(ringedBirdCommand.getThirdPrimary());
        ringedBird.setStateOfWingPoint(ringedBirdCommand.getStateOfWingPoint());
        ringedBird.setMass(ringedBirdCommand.getMass());
        ringedBird.setMoult(ringedBirdCommand.getMoult());
        ringedBird.setPlumageCode(ringedBirdCommand.getPlumageCode());
        ringedBird.setHindClaw(ringedBirdCommand.getHindClaw());
        ringedBird.setBillLength(ringedBirdCommand.getBillLength());
        ringedBird.setBillMethod(ringedBirdCommand.getBillMethod());
        ringedBird.setTotalHeadLength(ringedBirdCommand.getTotalHeadLength());
        ringedBird.setTarsus(ringedBirdCommand.getTarsus());
        ringedBird.setTarsusMethod(ringedBirdCommand.getTarsusMethod());
        ringedBird.setTailLength(ringedBirdCommand.getTailLength());
        ringedBird.setTailDifference(ringedBirdCommand.getTailDifference());
        ringedBird.setFatScore(ringedBirdCommand.getFatScore());
        ringedBird.setFatScoreMethod(ringedBirdCommand.getFatScoreMethod());
        ringedBird.setPectoralMuscleScore(ringedBirdCommand.getPectoralMuscleScore());
        ringedBird.setBroodPatch(ringedBirdCommand.getBroodPatch());
        ringedBird.setPrimaryScore(ringedBirdCommand.getPrimaryScore());
        ringedBird.setPrimaryMoult(ringedBirdCommand.getPrimaryMoult());
        ringedBird.setOldGreaterCoverts(ringedBirdCommand.getOldGreaterCoverts());
        ringedBird.setAlula(ringedBirdCommand.getAlula());
        ringedBird.setCarpalCovert(ringedBirdCommand.getCarpalCovert());
        ringedBird.setSexingMethod(ringedBirdCommand.getSexingMethod());
        ringedBird.setRemarks(ringedBirdCommand.getRemarks());
        ringedBird.setReference(ringedBirdCommand.getReference()); //REFERENCE marker !!!
        ringedBird.setMoreOtherMarks(ringedBirdCommand.getMoreOtherMarks());
    }
}
