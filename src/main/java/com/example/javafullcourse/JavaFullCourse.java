package com.example.javafullcourse;

import com.example.javafullcourse.learnNaverMail.EmailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

//@SpringBootApplication(scanBasePackages = {"com.example.springBootJoinAndLogin"})
@SpringBootApplication
public class JavaFullCourse {
    EmailSender emailSender;

    public static void main(String[] args) {
        SpringApplication.run(JavaFullCourse.class, args);
    }

    @GetMapping
    public void test() {
        System.out.println("test===");
        emailSender.sendEmil();

    }



}
