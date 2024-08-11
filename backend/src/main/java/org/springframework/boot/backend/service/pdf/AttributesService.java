package org.springframework.boot.backend.service.pdf;

import lombok.AllArgsConstructor;
import org.springframework.boot.backend.service.input.*;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class AttributesService {
    RingingSchemeService ringingSchemeService;
    PrimaryIdentificationMethodService primaryIdentificationMethodService;
    RingCodeService ringCodeService;
    VerificationOfTheMetalRingService verificationOfTheMetalRingService;
    MetalRingInformationService metalRingInformationService;
    OtherMarksInformationService otherMarksInformationService;
    BirdService birdService;
    ManipulatedService manipulatedService;
    MovedBeforeTheEncounterService movedBeforeTheEncounterService;
    CatchingMethodsService catchingMethodsService;
    CatchingLuresService catchingLuresService;
    SexService sexService;
    AgeService ageService;
    StatusService statusService;
    BroodSizeService broodSizeService;
    PullusAgeService pullusAgeService;
    AccuracyOfPullusAgeService accuracyOfPullusAgeService;
    AccuracyOfDateService accuracyOfDateService;
    PlaceService placeService;
    ConditionService conditionService;
    CircumstancesService circumstancesService;
    EURINGCodeIdentifierService euringCodeIdentifierService;
    StateOfWingPointService stateOfWingPointService;
    MoultService moultService;
    PlumageCodeService plumageCodeService;
    BillMethodService billMethodService;
    TarsusMethodService tarsusMethodService;
    FatScoreService fatScoreService;
    PectoralMuscleScoreService pectoralMuscleScoreService;
    BroodPatchService broodPatchService;
    PrimaryMoultService primaryMoultService;
    AlulaService alulaService;
    CarpalCovertService carpalCovertService;
    SexingMethodService sexingMethodService;
}
