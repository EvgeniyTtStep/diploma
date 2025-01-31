package com.example.diploma.email.events.pswdReset;

import com.example.diploma.model.users.TeacherbookUser;
import com.example.diploma.services.IUserService;
import com.example.diploma.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordResetListener implements
        ApplicationListener<OnPasswordResetEvent> {

    @Autowired
    private IUserService service;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SessionService sessionService;

    @Override
    public void onApplicationEvent(OnPasswordResetEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnPasswordResetEvent event) {
        TeacherbookUser user = event.getUser();
        sessionService.expireAllUserSessions(user.getUsername());
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String recipientAddress = user.getUsername();
        String subject = "Password Reset";
        String confirmationUrl
                = event.getAppUrl() + "/pswd_reset/" + user.getId() + "/passwordResetConfirm?token=" + token;
        String message = "Please, follow the link to confirm password reset for Teacherbook.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setFrom("46program@ukr.net");
        email.setSubject(subject);
        email.setText(message + "\r\n" + "http://localhost:8088" + confirmationUrl);
        mailSender.send(email);
    }
}
