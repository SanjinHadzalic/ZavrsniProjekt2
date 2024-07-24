package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *  Klasa RingedBird treba generirati .psv datoteku opisanu u RA Guideu, za slanje
 *  i primanje podataka
 */

@Entity
@Table(name = "ringed_bird")
@Data
public class RingedBird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private RingingScheme ringingScheme;
    @OneToOne
    private PrimaryIdentificationMethod primaryIdentificationMethod;
    @OneToOne
    @JoinColumn(name = "id")
    private RingCode ringCode; // alphanumeric 10 chars
    @OneToOne
    private VerificationOfTheMetalRing verificationOfTheMetalRing;
    @OneToOne
    private MetalRingInformation metalRingInformation;
    @OneToOne
    private OtherMarksInformation otherMarksInformation;
    @OneToOne
    private Bird species; // 5 digits
    @OneToOne
    private Manipulated manipulated;
    @OneToOne
    private MovedBeforeTheEncounter movedBeforeTheEncounter;
    @OneToOne
    private CatchingMethods catchingMethods;
    @OneToOne
    private CatchingLures catchingLures;
    @OneToOne
    private Sex sex;
    @OneToOne
    private Age age;
    @OneToOne
    private Status status;
    @OneToOne
    private BroodSize broodSize;
    @OneToOne
    private PullusAge pullusAge;
    @OneToOne
    private AccuracyOfPullusAge accuracyOfPullusAge;
    private LocalDate date; // 8 digits
    @OneToOne
    private AccuracyOfDate accuracyOfDate;
    private LocalTime time; // 4 characters
    @OneToOne
    private Place placeCode; // 4 characters
    private String geoCoordinates; // 15 chars, uzima iz Place
    @OneToOne
    private AccuracyOfCoordinates accuracyOfCoordinates;
    @OneToOne
    private Condition condition;
    @OneToOne
    private Circumstances circumstances;
    @OneToOne
    private EURINGCodeIdentifier euringCodeIdentifier;
    private String derivedDataDistance; // max 5 digs
    private String derivedDataDirection; // 3 digs with leading zeros
    private String derivedDataElapsedTime; // max 5 digits
    private Double wingLength; // max precision 0.5 mm
    private Double thirdPrimary; // max precision 0.5 mm
    @OneToOne
    private StateOfWingPoint stateOfWingPoint;
    private Double mass; // max precision 0.1 g
    @OneToOne
    private Moult moult;
    @OneToOne
    private PlumageCode plumageCode;
    private Double hindClaw; // maximum precision 0.1 g
    private Double billLength; // maximum precision 0.1 g
    @OneToOne
    private BillMethod billMethod;
    private Double totalHeadLength; // maximum precision 0.1 g
    private Double tarsus; // maximum precision 0.1 g
    @OneToOne
    private TarsusMethod tarsusMethod;
    private Double tailLength; // maximum precision 0.1 g
    private Double tailDifference; // maximum precision 0.1 g
    @OneToOne
    private FatScore fatScore;
    private String fatScoreMethod; // ESF method
    @OneToOne
    private PectoralMuscleScore pectoralMuscleScore;
    @OneToOne
    private BroodPatch broodPatch;
    private String primaryScore; // 2 digits; ignore
    @OneToOne
    private PrimaryMoult primaryMoult; // 10 chars
    private String oldGreaterCoverts;
    @OneToOne
    private Alula alula;
    @OneToOne
    private CarpalCovert carpalCovert;
    @OneToOne
    @JoinColumn(name = "id")
    private SexingMethod sexingMethod;
    private String placeName; // uzima iz Place objekta
    private String remarks; // opaske
    private String reference; // za referenciranje originalno prstenovane vrste
    private String latitude; //
    private String longitude;
    private String currentPlaceCode; // 4 chars
    private String moreOtherMarks;
    //TODO napraviti atribute unutar tablice "ringed_bird"
    //TODO repo, service & controller
}
