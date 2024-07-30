package org.springframework.boot.backend.entity.command;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.backend.entity.input.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RingedBirdCommand {
    @NotNull(message = "Ringing Scheme is mandatory")
    private RingingScheme ringingScheme;
    @NotNull(message = "Primary Identification method is mandatory")
    private PrimaryIdentificationMethod primaryIdentificationMethod;
    @NotNull(message = "Ring code is mandatory")
    private RingCode ringCode; // alphanumeric 10 chars
    private VerificationOfTheMetalRing verificationOfTheMetalRing;
    @NotNull(message = "Metal Ring Information is mandatory")
    private MetalRingInformation metalRingInformation;
    private OtherMarksInformation otherMarksInformation;
    @NotNull(message = "Bird Species is mandatory")
    private Bird species; // 5 digits
    private Manipulated manipulated;
    private MovedBeforeTheEncounter movedBeforeTheEncounter;
    @NotNull(message = "Catching method is mandatory")
    private CatchingMethods catchingMethods;
    @NotNull(message = "Catching lure is mandatory")
    private CatchingLures catchingLures;
    @NotNull(message = "Sex is mandatory")
    private Sex sex;
    @NotNull(message = "Age is mandatory")
    private Age age;
    @NotNull(message = "Status is mandatory")
    private Status status;
    @NotNull(message = "Brood size is mandatory")
    private BroodSize broodSize;
    private PullusAge pullusAge;
    private AccuracyOfPullusAge accuracyOfPullusAge;
    @NotNull(message = "Date is mandatory")
    private LocalDate date; // 8 digits
    private AccuracyOfDate accuracyOfDate;
    private LocalTime time; // 4 characters
    @NotNull(message = "Place is mandatory")
    private Place placeCode; // 4 characters
    private Condition condition;
    private Circumstances circumstances;
    @NotNull(message = "EURING Code Identifier is mandatory")
    private EURINGCodeIdentifier euringCodeIdentifier;
    private String derivedDataDistance; // max 5 digs
    private String derivedDataDirection; // 3 digs with leading zeros
    private String derivedDataElapsedTime; // max 5 digits
    private Double wingLength; // max precision 0.5 mm
    private Double thirdPrimary; // max precision 0.5 mm
    private StateOfWingPoint stateOfWingPoint;
    private Double mass; // max precision 0.1 g
    private Moult moult;
    private PlumageCode plumageCode;
    private Double hindClaw; // maximum precision 0.1 g
    private Double billLength; // maximum precision 0.1 g
    private BillMethod billMethod;
    private Double totalHeadLength; // maximum precision 0.1 g
    private Double tarsus; // maximum precision 0.1 g
    private TarsusMethod tarsusMethod;
    private Double tailLength; // maximum precision 0.1 g
    private Double tailDifference; // maximum precision 0.1 g
    private FatScore fatScore;
    private String fatScoreMethod; // ESF method
    private PectoralMuscleScore pectoralMuscleScore;
    private BroodPatch broodPatch;
    private String primaryScore; // 2 digits; ignore
    private PrimaryMoult primaryMoult; // 10 chars
    private String oldGreaterCoverts;
    private Alula alula;
    private CarpalCovert carpalCovert;
    private SexingMethod sexingMethod;
    private String remarks; // opaske
    private String reference; // za referenciranje originalno prstenovane vrste
    private String moreOtherMarks;
}
