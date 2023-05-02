package com.example.springBootJoinAndLogin.registration.service;

import com.example.springBootJoinAndLogin.registration.dao.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegisterationService {
    public String register(RegistrationRequest request ) {
        return "works";
    }
}
