package com.example.springBootJoinAndLogin.registration.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public RegistrationRequest() {
        super();
    }
    
    public RegistrationRequest(String firstName,
                               String lastName,
                               String email,
                               String password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


}
