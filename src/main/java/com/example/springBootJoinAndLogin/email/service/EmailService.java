package com.example.springBootJoinAndLogin.email.service;

import com.example.springBootJoinAndLogin.email.entity.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final JavaMailSender mailSernder;

    @Override
    public void send(String to, String email) {

    };

}
