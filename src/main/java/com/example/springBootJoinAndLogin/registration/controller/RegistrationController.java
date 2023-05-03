package com.example.springBootJoinAndLogin.registration.controller;

import com.example.springBootJoinAndLogin.registration.dao.RegistrationRequest;
import com.example.springBootJoinAndLogin.registration.service.RegisterationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegisterationService registerationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registerationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registerationService.confirmToken(token);
    }

}
