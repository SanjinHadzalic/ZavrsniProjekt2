package org.springframework.boot.backend.service.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.backend.entity.input.RingCode;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.repository.input.RingedBirdRepository;
import org.springframework.boot.backend.service.input.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenerateDocumentService {
    private final RingedBirdRepository ringedBirdRepository;
    RingedBirdService ringedBirdService;
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

    public byte[] generatePdfFile() {
        List<RingedBird> ringedBirds = ringedBirdRepository.findAll();
        return createPdfDocument(ringedBirds, "ReportAll.pdf");
    }

    public byte[] generatePdfFileByUsername(String username) {
        List<RingedBird> ringedBirds = ringedBirdRepository.findAllByRingCode_AppUser_Username(username);
        String fileName = "Report_" + username + ".pdf";
        return createPdfDocument(ringedBirds, fileName);
    }

    public byte[] generateExcelFile() {
        List<RingedBird> ringedBirds = ringedBirdRepository.findAll();
        return createExcelDocument(ringedBirds, "RingedBirdsReport.xlsx");
    }

    public byte[] generateExcelFileByUsername(String username) {
        List<RingedBird> ringedBirds = ringedBirdRepository.findAllByRingCode_AppUser_Username(username);
        return createExcelDocument(ringedBirds, "RingedBirdsReport_" + username + ".xlsx");
    }

    private byte[] createExcelDocument(List<RingedBird> ringedBirds, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Ringed Birds");

        Row headerRow = sheet.createRow(0);
        String[] headers = {
                "ID", "Ringing Scheme", "Primary Identification Method", "Ring Code", "Verification Of The Metal Ring",
                "Metal Ring Information", "Other Marks Information", "Species", "Manipulated", "Moved Before The Encounter",
                "Catching Methods", "Catching Lures", "Sex", "Age", "Status", "Brood Size", "Pullus Age",
                "Accuracy Of Pullus Age", "Date", "Accuracy Of Date", "Time", "Place Code", "Condition",
                "Circumstances", "EURING Code Identifier", "Derived Data Distance", "Derived Data Direction",
                "Derived Data Elapsed Time", "Wing Length", "Third Primary", "State Of Wing Point", "Mass",
                "Moult", "Plumage Code", "Hind Claw", "Bill Length", "Bill Method", "Total Head Length",
                "Tarsus", "Tarsus Method", "Tail Length", "Tail Difference", "Fat Score", "Fat Score Method",
                "Pectoral Muscle Score", "Brood Patch", "Primary Score", "Primary Moult", "Old Greater Coverts",
                "Alula", "Carpal Covert", "Sexing Method", "Remarks", "Reference", "More Other Marks"
        };

        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        int rowNum = 1;
        for (RingedBird bird : ringedBirds) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(bird.getId());
            row.createCell(1).setCellValue(bird.getRingingScheme() != null ? bird.getRingingScheme().getId().toString() : "");
            row.createCell(2).setCellValue(bird.getPrimaryIdentificationMethod() != null ? bird.getPrimaryIdentificationMethod().getId().toString() : "");
            row.createCell(3).setCellValue(bird.getRingCode().getCode() != null ? bird.getRingCode().getCode() : "");
            row.createCell(4).setCellValue(bird.getVerificationOfTheMetalRing() != null ? bird.getVerificationOfTheMetalRing().getId().toString() : "");
            row.createCell(5).setCellValue(bird.getMetalRingInformation() != null ? bird.getMetalRingInformation().getId().toString() : "");
            row.createCell(6).setCellValue(bird.getOtherMarksInformation() != null ? bird.getOtherMarksInformation().getId().toString() : "");
            row.createCell(7).setCellValue(bird.getSpecies() != null ? bird.getSpecies().getId().toString() : "");
            row.createCell(8).setCellValue(bird.getManipulated() != null ? bird.getManipulated().getId().toString() : "");
            row.createCell(9).setCellValue(bird.getMovedBeforeTheEncounter() != null ? bird.getMovedBeforeTheEncounter().getId().toString() : "");
            row.createCell(10).setCellValue(bird.getCatchingMethods() != null ? bird.getCatchingMethods().getId().toString() : "");
            row.createCell(11).setCellValue(bird.getCatchingLures() != null ? bird.getCatchingLures().getId().toString() : "");
            row.createCell(12).setCellValue(bird.getSex() != null ? bird.getSex().getId().toString() : "");
            row.createCell(13).setCellValue(bird.getAge() != null ? bird.getAge().getId().toString() : "");
            row.createCell(14).setCellValue(bird.getStatus() != null ? bird.getStatus().getId().toString() : "");
            row.createCell(15).setCellValue(bird.getBroodSize() != null ? bird.getBroodSize().getId().toString() : "");
            row.createCell(16).setCellValue(bird.getPullusAge() != null ? bird.getPullusAge().getId().toString() : "");
            row.createCell(17).setCellValue(bird.getAccuracyOfPullusAge() != null ? bird.getAccuracyOfPullusAge().getId().toString() : "");
            row.createCell(18).setCellValue(bird.getDate() != null ? bird.getDate().toString() : "");
            row.createCell(19).setCellValue(bird.getAccuracyOfDate() != null ? bird.getAccuracyOfDate().getId().toString() : "");
            row.createCell(20).setCellValue(bird.getTime() != null ? bird.getTime().toString() : "");
            row.createCell(21).setCellValue(bird.getPlaceCode() != null ? bird.getPlaceCode().getId().toString() : "");
            row.createCell(22).setCellValue(bird.getCondition() != null ? bird.getCondition().getId().toString() : "");
            row.createCell(23).setCellValue(bird.getCircumstances() != null ? bird.getCircumstances().getId().toString() : "");
            row.createCell(24).setCellValue(bird.getEuringCodeIdentifier() != null ? bird.getEuringCodeIdentifier().getId().toString() : "");
            row.createCell(25).setCellValue(bird.getDerivedDataDistance() != null ? bird.getDerivedDataDistance() : "");
            row.createCell(26).setCellValue(bird.getDerivedDataDirection() != null ? bird.getDerivedDataDirection() : "");
            row.createCell(27).setCellValue(bird.getDerivedDataElapsedTime() != null ? bird.getDerivedDataElapsedTime() : "");
            row.createCell(28).setCellValue(bird.getWingLength() != null ? bird.getWingLength() : 0.0);
            row.createCell(29).setCellValue(bird.getThirdPrimary() != null ? bird.getThirdPrimary() : 0.0);
            row.createCell(30).setCellValue(bird.getStateOfWingPoint() != null ? bird.getStateOfWingPoint().getId().toString() : "");
            row.createCell(31).setCellValue(bird.getMass() != null ? bird.getMass() : 0.0);
            row.createCell(32).setCellValue(bird.getMoult() != null ? bird.getMoult().getId().toString() : "");
            row.createCell(33).setCellValue(bird.getPlumageCode() != null ? bird.getPlumageCode().getId().toString() : "");
            row.createCell(34).setCellValue(bird.getHindClaw() != null ? bird.getHindClaw() : 0.0);
            row.createCell(35).setCellValue(bird.getBillLength() != null ? bird.getBillLength() : 0.0);
            row.createCell(36).setCellValue(bird.getBillMethod() != null ? bird.getBillMethod().getId().toString() : "");
            row.createCell(37).setCellValue(bird.getTotalHeadLength() != null ? bird.getTotalHeadLength() : 0.0);
            row.createCell(38).setCellValue(bird.getTarsus() != null ? bird.getTarsus() : 0.0);
            row.createCell(39).setCellValue(bird.getTarsusMethod() != null ? bird.getTarsusMethod().getId().toString() : "");
            row.createCell(40).setCellValue(bird.getTailLength() != null ? bird.getTailLength() : 0.0);
            row.createCell(41).setCellValue(bird.getTailDifference() != null ? bird.getTailDifference() : 0.0);
            row.createCell(42).setCellValue(bird.getFatScore() != null ? bird.getFatScore().getId().toString() : "");
            row.createCell(43).setCellValue(bird.getFatScoreMethod() != null ? bird.getFatScoreMethod() : "");
            row.createCell(44).setCellValue(bird.getPectoralMuscleScore() != null ? bird.getPectoralMuscleScore().getId().toString() : "");
            row.createCell(45).setCellValue(bird.getBroodPatch() != null ? bird.getBroodPatch().getId().toString() : "");
            row.createCell(46).setCellValue(bird.getPrimaryScore() != null ? bird.getPrimaryScore() : "");
            row.createCell(47).setCellValue(bird.getPrimaryMoult() != null ? bird.getPrimaryMoult().getId().toString() : "");
            row.createCell(48).setCellValue(bird.getOldGreaterCoverts() != null ? bird.getOldGreaterCoverts() : "");
            row.createCell(49).setCellValue(bird.getAlula() != null ? bird.getAlula().getId().toString() : "");
            row.createCell(50).setCellValue(bird.getCarpalCovert() != null ? bird.getCarpalCovert().getId().toString() : "");
            row.createCell(51).setCellValue(bird.getSexingMethod() != null ? bird.getSexingMethod().getId().toString() : "");
            row.createCell(52).setCellValue(bird.getRemarks() != null ? bird.getRemarks() : "");
            row.createCell(53).setCellValue(bird.getReference() != null ? bird.getReference() : "");
            row.createCell(54).setCellValue(bird.getMoreOtherMarks() != null ? bird.getMoreOtherMarks() : "");
        }

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            workbook.write(byteArrayOutputStream);
            workbook.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error generating Excel file", e);
        }
    }


    private byte[] createPdfDocument(List<RingedBird> ringedBirds, String fileName) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            addImage(document);
            addTitle(document);
            addTable(document, ringedBirds);

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();

        } catch (DocumentException | IOException | URISyntaxException e) {
            throw new RuntimeException("Error generating PDF", e);
        } finally {
            document.close();
        }

        return byteArrayOutputStream.toByteArray();
    }

    private void addImage(Document document) throws DocumentException, IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("homePage.jpg").toURI());
        Image image = Image.getInstance(path.toAbsolutePath().toString());
        image.scaleToFit(200, 200);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);
    }

    private void addTitle(Document document) throws DocumentException {
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph title = new Paragraph("Ringed Birds Report", font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);
    }

    private void addTable(Document document, List<RingedBird> ringedBirds) throws DocumentException {
        PdfPTable table = new PdfPTable(4);

        // Table headers
        table.addCell("ID");
        table.addCell("Bird Name");
        table.addCell("Ring Code");
        table.addCell("Location");

        // Add data to cells
        for (RingedBird bird : ringedBirds) {
            table.addCell(bird.getId().toString());
            table.addCell(bird.getSpecies().getCommonName());
            table.addCell(bird.getRingCode().getCode());
            table.addCell(bird.getPlaceCode().getName());
        }
        document.add(table);
    }

    public List<String> processExcelFile(MultipartFile file) throws IOException {
        List<String> existingRingCodes = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            // Check if the first column is empty
            Cell firstCell = row.getCell(0);
            if (firstCell == null || firstCell.getCellType() == CellType.BLANK) {
                continue; // Skip this row if the first cell is empty
            }

            String ringCode = row.getCell(3).getStringCellValue();
            if (ringedBirdRepository.existsRingedBirdByRingCode_Code(ringCode)) {
                existingRingCodes.add(ringCode);
            } else {
                RingedBird bird = new RingedBird();

                Long id = (long) row.getCell(0).getNumericCellValue();

                if (ringedBirdService.getRingedBirdById(id).isPresent()) {
                    bird.setId(ringedBirdService.generateMaxId());
                } else {
                    bird.setId((long) row.getCell(0).getNumericCellValue());
                }

                RingCode rc = new RingCode();
                rc.setCode(ringCode);

                Optional<RingCode> optionalRingCode = ringCodeService.getRingCodeByCode(ringCode);
                if (!optionalRingCode.isPresent()) {
                    ringCodeService.saveNewRingCode(rc);
                } else {
                    rc = optionalRingCode.get();
                }
                bird.setRingCode(rc);


                bird.setRingingScheme(ringingSchemeService.getRingingSchemeById(Long.valueOf(row.getCell(1).getStringCellValue())).orElse(null));
                bird.setPrimaryIdentificationMethod(primaryIdentificationMethodService.getPrimaryIdentificationMethodById(Long.valueOf(row.getCell(2).getStringCellValue())).orElse(null));
                bird.setVerificationOfTheMetalRing(verificationOfTheMetalRingService.getVerificationOfTheMetalRingById(Long.valueOf((long) row.getCell(4).getNumericCellValue())).orElse(null));
                bird.setMetalRingInformation(metalRingInformationService.getMetalRingInformationById(Long.valueOf((long) row.getCell(5).getNumericCellValue())).orElse(null));
                bird.setOtherMarksInformation(otherMarksInformationService.getOtherMarksInformationById(Long.valueOf((long) row.getCell(6).getNumericCellValue())).orElse(null));
                bird.setSpecies(birdService.getBird(Long.valueOf(row.getCell(7).getStringCellValue())).orElse(null));
                bird.setManipulated(manipulatedService.getManipulatedById(Long.valueOf((long) row.getCell(8).getNumericCellValue())).orElse(null));
                bird.setMovedBeforeTheEncounter(movedBeforeTheEncounterService.getMovedBeforeTheEncounterById(Long.valueOf((long) row.getCell(9).getNumericCellValue())).orElse(null));
                bird.setCatchingMethods(catchingMethodsService.getCatchingMethodsById(Long.valueOf((long) row.getCell(10).getNumericCellValue())).orElse(null));
                bird.setCatchingLures(catchingLuresService.getCatchingLuresById(Long.valueOf((long) row.getCell(11).getNumericCellValue())).orElse(null));
                bird.setSex(sexService.findSexById(Long.valueOf((long) row.getCell(12).getNumericCellValue())).orElse(null));
                bird.setAge(ageService.getAgeById(Long.valueOf((long) row.getCell(13).getNumericCellValue())).orElse(null));
                bird.setStatus(statusService.getStatusById(Long.valueOf((long) row.getCell(14).getNumericCellValue())).orElse(null));
                bird.setBroodSize(broodSizeService.getBroodSizeById(Long.valueOf((long) row.getCell(15).getNumericCellValue())).orElse(null));
                bird.setPullusAge(pullusAgeService.getPullusAgeById(Long.valueOf((long) row.getCell(16).getNumericCellValue())).orElse(null));
                bird.setAccuracyOfPullusAge(accuracyOfPullusAgeService.getAccuracyOfPullusAgeById(Long.valueOf((long) row.getCell(17).getNumericCellValue())).orElse(null));
                bird.setDate(LocalDate.parse(row.getCell(18).getStringCellValue()));
                bird.setAccuracyOfDate(accuracyOfDateService.getAccuracyOfDateById(Long.valueOf((long) row.getCell(19).getNumericCellValue())).orElse(null));
                bird.setTime(LocalTime.parse(row.getCell(20).getStringCellValue()));
                bird.setPlaceCode(placeService.getPlaceById(Long.valueOf(row.getCell(21).getStringCellValue())).orElse(null));
                bird.setCondition(conditionService.getConditionById(Long.valueOf((long) row.getCell(22).getNumericCellValue())).orElse(null));
                bird.setCircumstances(circumstancesService.getCircumstancesById(Long.valueOf((long) row.getCell(23).getNumericCellValue())).orElse(null));
                bird.setEuringCodeIdentifier(euringCodeIdentifierService.getEURINGCodeIdentifierById(Long.valueOf((long) row.getCell(24).getNumericCellValue())).orElse(null));
                bird.setDerivedDataDistance(String.valueOf(row.getCell(25).getNumericCellValue()));
                bird.setDerivedDataDirection(String.valueOf(row.getCell(26).getNumericCellValue()));
                bird.setDerivedDataElapsedTime(String.valueOf(row.getCell(27).getNumericCellValue()));
                bird.setWingLength(Double.valueOf(row.getCell(28).getNumericCellValue()));
                bird.setThirdPrimary(Double.valueOf(row.getCell(28).getNumericCellValue()));
                bird.setStateOfWingPoint(stateOfWingPointService.getStateOfWingPointById(Long.valueOf((long) row.getCell(30).getNumericCellValue())).orElse(null));
                bird.setMass(Double.valueOf(row.getCell(31).getNumericCellValue()));
                bird.setMoult(moultService.getMoultById(Long.valueOf((long) row.getCell(32).getNumericCellValue())).orElse(null));
                bird.setPlumageCode(plumageCodeService.getPlumageCodeById(Long.valueOf((long) row.getCell(33).getNumericCellValue())).orElse(null));
                bird.setHindClaw(Double.valueOf(row.getCell(34).getNumericCellValue()));
                bird.setBillLength(Double.valueOf(row.getCell(35).getNumericCellValue()));
                bird.setBillMethod(billMethodService.getBillMethodById(Long.valueOf((long) row.getCell(36).getNumericCellValue())).orElse(null));
                bird.setTotalHeadLength(Double.valueOf(row.getCell(37).getNumericCellValue()));
                bird.setTarsus(Double.valueOf(row.getCell(38).getNumericCellValue()));
                bird.setTarsusMethod(tarsusMethodService.getTarsusMethodById(Long.valueOf((long) row.getCell(39).getNumericCellValue())).orElse(null));
                bird.setTailLength(Double.valueOf(row.getCell(40).getNumericCellValue()));
                bird.setTailDifference(Double.valueOf(row.getCell(41).getNumericCellValue()));
                bird.setFatScore(fatScoreService.getFatScore(Long.valueOf((long) row.getCell(42).getNumericCellValue())).orElse(null));
                bird.setFatScoreMethod(String.valueOf(row.getCell(43).getNumericCellValue()));
                bird.setPectoralMuscleScore(pectoralMuscleScoreService.getPectoralMuscleScoreById(Long.valueOf((long) row.getCell(44).getNumericCellValue())).orElse(null));
                bird.setBroodPatch(broodPatchService.getBroodPatchById(Long.valueOf((long) row.getCell(45).getNumericCellValue())).orElse(null));
                bird.setPrimaryScore(String.valueOf(row.getCell(46).getNumericCellValue()));
                bird.setPrimaryMoult(primaryMoultService.getPrimaryMoultById(Long.valueOf((long) row.getCell(47).getNumericCellValue())).orElse(null));
                bird.setOldGreaterCoverts(String.valueOf(row.getCell(48).getNumericCellValue()));
                bird.setAlula(alulaService.getAlulaById(Long.valueOf((long) row.getCell(49).getNumericCellValue())).orElse(null));
                bird.setCarpalCovert(carpalCovertService.getCarpalCovertById(Long.valueOf((long) row.getCell(50).getNumericCellValue())).orElse(null));
                bird.setSexingMethod(sexingMethodService.getSexingMethodById(Long.valueOf((long) row.getCell(51).getNumericCellValue())).orElse(null));
                bird.setRemarks(String.valueOf(row.getCell(52).getStringCellValue()));
                bird.setReference(String.valueOf(row.getCell(53).getStringCellValue()));
                bird.setMoreOtherMarks(String.valueOf(row.getCell(54).getStringCellValue()));

                ringedBirdRepository.save(bird);
            }
        }
        workbook.close();
        return existingRingCodes;
    }
}
