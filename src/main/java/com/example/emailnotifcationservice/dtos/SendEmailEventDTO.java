package com.example.emailnotifcationservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailEventDTO {
    private String to;
    private String subject;
    private String body;
}
