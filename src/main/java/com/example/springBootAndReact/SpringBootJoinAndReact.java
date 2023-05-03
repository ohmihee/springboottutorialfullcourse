package com.example.springBootAndReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.example.springBootJoinAndLogin"})
@SpringBootApplication
public class SpringBootJoinAndReact {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJoinAndReact.class, args);
    }

}
// http://localhost:8080/api/v1/hello 로 들어가면 로그인 폼 나옴
// https://github.com/amigoscode/login-registration-backend