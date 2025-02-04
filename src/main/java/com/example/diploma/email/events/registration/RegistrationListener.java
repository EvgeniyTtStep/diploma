package com.example.diploma.email.events.registration;

import com.example.diploma.model.users.TeacherbookUser;
import com.example.diploma.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private IUserService service;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        TeacherbookUser user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String recipientAddress = user.getUsername();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/registrationConfirm?token=" + token;
        String message = "Please, follow the link to confirm registration for Teacherbook.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setFrom("46program@ukr.net");
        email.setSubject(subject);
        email.setText(message + "\r\n" + "http://localhost:8088" + confirmationUrl);
        mailSender.send(email);
    }
}
