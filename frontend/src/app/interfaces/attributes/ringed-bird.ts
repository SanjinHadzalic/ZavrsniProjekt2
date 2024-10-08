import { Time } from "@angular/common";
import { Bird } from "../../classes/bird.model";
import { AccuracyOfDate } from "./accuracy-of-date";
import { AccuracyOfPullusAge } from "./accuracy-of-pullus-age";
import { Age } from "./age";
import { BroodSize } from "./brood-size";
import { CatchingLures } from "./catching-lures";
import { CatchingMethods } from "./catching-methods";
import { Manipulated } from "./manipulated";
import { MetalRingInformation } from "./metal-ring-information";
import { MovedBeforeTheEncounter } from "./moved-before-the-encounter";
import { OtherMarksInformation } from "./other-marks-information";
import { PrimaryIdentificationMethod } from "./primary-identification-method";
import { RingCode } from "./ring-code";
import { RingingScheme } from "./ringing-scheme";
import { Sex } from "./sex";
import { Status } from "./status";
import { VerificationOfTheMetalRing } from "./verification-of-the-metal-ring";
import { Place } from "./place";
import { Circumstances } from "./circumstances";
import { EuringCodeIdentifier } from "./euring-code-identifier";
import { StateOfWingPoint } from "./state-of-wing-point";
import { Moult } from "./moult";
import { PlumageCode } from "./plumage-code";
import { BillMethod } from "./bill-method";
import { TarsusMethod } from "./tarsus-method";
import { FatScore } from "./fat-score";
import { PectoralMuscleScore } from "./pectoral-muscle-score";
import { BroodPatch } from "./brood-patch";
import { PrimaryMoult } from "./primary-moult";
import { Alula } from "./alula";
import { CarpalCovert } from "./carpal-covert";
import { SexingMethod } from "./sexing-method";
import { PullusAge } from "./pullus-age";
import { Condition } from "./condition";

export interface RingedBird {
    id: number;
    ringingScheme: RingingScheme;
    primaryIdentificationMethod: PrimaryIdentificationMethod;
    ringCode: RingCode;
    verificationOfTheMetalRing: VerificationOfTheMetalRing;
    metalRingInformation: MetalRingInformation;
    otherMarksInformation: OtherMarksInformation;
    species: Bird;
    manipulated: Manipulated;
    movedBeforeTheEncounter: MovedBeforeTheEncounter;
    catchingMethods: CatchingMethods;
    catchingLures: CatchingLures;
    sex: Sex;
    age: Age;
    status: Status;
    broodSize: BroodSize; 
    pullusAge: PullusAge; 
    accuracyOfPullusAge: AccuracyOfPullusAge;
    date: Date;
    accuracyOfDate: AccuracyOfDate;
    time: Time;
    placeCode: Place;
    condition: Condition; 
    circumstances: Circumstances;
    euringCodeIdentifier: EuringCodeIdentifier;
    derivedDataDistance: string;
    derivedDataDirection: string;
    derivedDataElapsedTime: string;
    wingLength: number;
    thirdPrimary: number;
    stateOfWingPoint: StateOfWingPoint;
    mass: number;
    moult: Moult;
    plumageCode: PlumageCode;
    hindClaw: number;
    billLength: number;
    billMethod: BillMethod;
    totalHeadLength: number;
    tarsus: number;
    tarsusMethod: TarsusMethod;
    tailLength: number;
    tailDifference: number;
    fatScore: FatScore;
    fatScoreMethod: string; // ETF 
    pectoralMuscleScore: PectoralMuscleScore;
    broodPatch: BroodPatch;
    primaryMoult: PrimaryMoult;
    oldGreaterCoverts: string;
    alula: Alula;
    carpalCovert: CarpalCovert;
    sexingMethod: SexingMethod;
    remarks: string;
    reference: string;
    moreOtherMarks: string;
  }
  