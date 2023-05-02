package com.example.springBootJoinAndLogin.registration.service;

import com.example.springBootJoinAndLogin.appuser.entity.AppUser;
import com.example.springBootJoinAndLogin.appuser.entity.AppUserRole;
import com.example.springBootJoinAndLogin.appuser.service.AppUserService;
import com.example.springBootJoinAndLogin.registration.dao.RegistrationRequest;
import com.example.springBootJoinAndLogin.registration.token.entity.ConfirmationToken;
import com.example.springBootJoinAndLogin.registration.token.service.ConfirmationTokenService;
import com.example.springBootJoinAndLogin.registration.util.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegisterationService {
    private EmailValidator emailValidator;
    private AppUserService appUserService;
    private ConfirmationTokenService confirmationTokenService;
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

    @Transactional
    public String confirmToken (String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow(() -> new IllegalStateException("token not found"));
        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException(" token expired ");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
