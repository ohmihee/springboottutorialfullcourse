package com.example.springBootJoinAndLogin.email.entity;

public interface EmailSender {
    void send(String to, String email);
}
