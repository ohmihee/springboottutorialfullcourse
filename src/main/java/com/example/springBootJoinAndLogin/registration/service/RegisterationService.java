package com.example.springBootJoinAndLogin.registration.service;

import com.example.springBootJoinAndLogin.appuser.entity.AppUser;
import com.example.springBootJoinAndLogin.appuser.entity.AppUserRole;
import com.example.springBootJoinAndLogin.appuser.service.AppUserService;
import com.example.springBootJoinAndLogin.registration.dao.RegistrationRequest;
import com.example.springBootJoinAndLogin.registration.util.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterationService {
    private EmailValidator emailValidator;
    private AppUserService appUserService;
    public String register(RegistrationRequest request ) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
            new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(), request.
                getPassword(),
                AppUserRole.USER)
        );
    }
}
