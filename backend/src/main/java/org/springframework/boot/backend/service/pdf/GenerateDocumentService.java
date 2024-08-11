package org.springframework.boot.backend.service.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.backend.entity.input.RingedBird;
import org.springframework.boot.backend.repository.input.RingedBirdRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class GenerateDocumentService {
    private final RingedBirdRepository ringedBirdRepository;

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

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Bird Name");
        headerRow.createCell(2).setCellValue("Ring Code");
        headerRow.createCell(3).setCellValue("Location");

        // Add data to rows
        int rowNum = 1;
        for (RingedBird bird : ringedBirds) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(bird.getId());
            row.createCell(1).setCellValue(bird.getSpecies().getCommonName());
            row.createCell(2).setCellValue(bird.getRingCode().getCode());
            row.createCell(3).setCellValue(bird.getPlaceCode().getName());
        }

        // Write the output to a byte array
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
}
