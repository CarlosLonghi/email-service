package com.longhi.email_service.controllers;

import com.longhi.email_service.application.EmailSenderService;
import com.longhi.email_service.core.EmailRequest;
import com.longhi.email_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            this.emailSenderService.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
