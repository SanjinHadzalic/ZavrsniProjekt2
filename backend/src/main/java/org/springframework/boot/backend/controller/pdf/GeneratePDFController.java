package org.springframework.boot.backend.controller.pdf;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.backend.service.pdf.GeneratePDFService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class GeneratePDFController {
    private final GeneratePDFService generatePDFService;

    // Existing method to generate a PDF for all ringed birds
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf() {
        byte[] pdfBytes = generatePDFService.generatePdfFile();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ringed_birds_report.pdf");

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }

    // New method to generate a PDF based on a username
    @GetMapping("/pdf/{username}")
    public ResponseEntity<byte[]> generatePdfByUsername(@PathVariable String username) {
        byte[] pdfBytes = generatePDFService.generatePdfFileByUsername(username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Report_" + username + ".pdf");

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
}
