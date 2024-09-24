package com.longhi.email_service.application;

import com.longhi.email_service.adapters.EmailSenderGateway;
import com.longhi.email_service.core.cases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        this.emailSenderGateway.sendEmail(toEmail, subject, body);
    }
}
