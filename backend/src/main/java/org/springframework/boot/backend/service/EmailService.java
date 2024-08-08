package org.springframework.boot.backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.boot.backend.entity.user.ApplicationUser;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final ResourceLoader resourceLoader;

    @Async
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom("randommail@hotmail.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    public void sendHtmlEmail(ApplicationUser user, String subject) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("random12@gmail.com"));
        message.setSubject(subject);
        message.setRecipients(MimeMessage.RecipientType.TO, "sh14.sanjin@yahoo.com"); //userDTO.getAddress()

        String htmlTemplate = readFile("message.html");
        String htmlContent = htmlTemplate.replace("${name}", user.getFirstname() + " " + user.getLastname());
        htmlContent = htmlContent.replace("${message}", "This is a test message, using HTML template");

        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }

    public void sendMailWithAttachment(String to, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("random12@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        FileSystemResource file = new FileSystemResource(new File("src/main/resources/homePage.png"));
        helper.addAttachment("homePage.png", file);

        mailSender.send(message);
    }
    public String readFile(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        return Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
    }}
