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
    @ManyToOne
    @JoinColumn(name = "ringing_scheme_id")
    private RingingScheme ringingScheme;

    @ManyToOne
    @JoinColumn(name = "primary_identification_method_id")
    private PrimaryIdentificationMethod primaryIdentificationMethod;

    @ManyToOne
    @JoinColumn(name = "ring_code_id")
    private RingCode ringCode; // alphanumeric 10 chars

    @ManyToOne
    private VerificationOfTheMetalRing verificationOfTheMetalRing;
    @ManyToOne
    private MetalRingInformation metalRingInformation;
    @ManyToOne
    private OtherMarksInformation otherMarksInformation;
    @ManyToOne
    private Bird species; // 5 digits
    @ManyToOne
    private Manipulated manipulated;
    @ManyToOne
    private MovedBeforeTheEncounter movedBeforeTheEncounter;
    @ManyToOne
    private CatchingMethods catchingMethods;
    @ManyToOne
    private CatchingLures catchingLures;
    @ManyToOne
    private Sex sex;
    @ManyToOne
    private Age age;
    @ManyToOne
    private Status status;
    @ManyToOne
    private BroodSize broodSize;
    @ManyToOne
    private PullusAge pullusAge;
    @ManyToOne
    private AccuracyOfPullusAge accuracyOfPullusAge;
    private LocalDate date; // 8 digits
    @ManyToOne
    private AccuracyOfDate accuracyOfDate;
    private LocalTime time; // 4 characters
    @ManyToOne
    private Place placeCode; // 4 characters
    private String geoCoordinates; // 15 chars, uzima iz Place
    @ManyToOne
    private AccuracyOfCoordinates accuracyOfCoordinates;
    @ManyToOne
    private Condition condition;
    @ManyToOne
    private Circumstances circumstances;
    @ManyToOne
    private EURINGCodeIdentifier euringCodeIdentifier;
    private String derivedDataDistance; // max 5 digs
    private String derivedDataDirection; // 3 digs with leading zeros
    private String derivedDataElapsedTime; // max 5 digits
    private Double wingLength; // max precision 0.5 mm
    private Double thirdPrimary; // max precision 0.5 mm
    @ManyToOne
    private StateOfWingPoint stateOfWingPoint;
    private Double mass; // max precision 0.1 g
    @ManyToOne
    private Moult moult;
    @ManyToOne
    private PlumageCode plumageCode;
    private Double hindClaw; // maximum precision 0.1 g
    private Double billLength; // maximum precision 0.1 g
    @ManyToOne
    private BillMethod billMethod;
    private Double totalHeadLength; // maximum precision 0.1 g
    private Double tarsus; // maximum precision 0.1 g
    @ManyToOne
    private TarsusMethod tarsusMethod;
    private Double tailLength; // maximum precision 0.1 g
    private Double tailDifference; // maximum precision 0.1 g
    @ManyToOne
    private FatScore fatScore;
    private String fatScoreMethod; // ESF method
    @ManyToOne
    private PectoralMuscleScore pectoralMuscleScore;
    @ManyToOne
    private BroodPatch broodPatch;
    private String primaryScore; // 2 digits; ignore
    @ManyToOne
    private PrimaryMoult primaryMoult; // 10 chars
    private String oldGreaterCoverts;
    @ManyToOne
    private Alula alula;
    @ManyToOne
    private CarpalCovert carpalCovert;

    @ManyToOne
//    @JoinColumn(name = "sexing_method_id")
    private SexingMethod sexingMethod;

    private String placeName; // uzima iz Place objekta
    private String remarks; // opaske
    private String reference; // za referenciranje originalno prstenovane vrste
    private String latitude; //
    private String longitude;
    private String currentPlaceCode; // 4 chars
    private String moreOtherMarks;
}
