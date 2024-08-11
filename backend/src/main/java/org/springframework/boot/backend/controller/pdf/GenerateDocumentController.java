package org.springframework.boot.backend.controller.pdf;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.service.pdf.GenerateDocumentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class GenerateDocumentController {
    private final GenerateDocumentService generateDocumentService;

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf() {
        byte[] pdfBytes = generateDocumentService.generatePdfFile();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ringed_birds_report.pdf");

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }

    @GetMapping("/pdf/{username}")
    public ResponseEntity<byte[]> generatePdfByUsername(@PathVariable String username) {
        byte[] pdfBytes = generateDocumentService.generatePdfFileByUsername(username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Report_" + username + ".pdf");

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }

    @GetMapping("/excel")
    public ResponseEntity<byte[]> generateExcel() {
        byte[] excelBytes = generateDocumentService.generateExcelFile();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "RingedBirdsReport.xlsx");

        return ResponseEntity.ok().headers(headers).body(excelBytes);
    }

    @GetMapping("/excel/{username}")
    public ResponseEntity<byte[]> generateExcelByUsername(@PathVariable String username) {
        byte[] excelBytes = generateDocumentService.generateExcelFileByUsername(username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "RingedBirdsReport_" + username + ".xlsx");

        return ResponseEntity.ok().headers(headers).body(excelBytes);
    }
}
