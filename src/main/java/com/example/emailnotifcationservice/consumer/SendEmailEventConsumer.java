package com.example.emailnotifcationservice.consumer;


import com.example.emailnotifcationservice.dtos.SendEmailEventDTO;
import com.example.emailnotifcationservice.utils.EmailUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

@Service
public class SendEmailEventConsumer {

    @Autowired
    private ObjectMapper mapper;

    @KafkaListener(topics = "sendEmailEvent", groupId = "email-group")
    public void handleSendEmailEvent(String message) throws JsonProcessingException {
        SendEmailEventDTO dto = mapper.readValue(
                message,
                SendEmailEventDTO.class
        );

        String subject = dto.getSubject();
        String toEmail = dto.getTo();
        String body = dto.getBody();

        // Simulate sending email by printing to console
        System.out.println("Sending email to: " + toEmail);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "your-email-id",
                        "your-email-password");
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, subject, body);

    }

}
