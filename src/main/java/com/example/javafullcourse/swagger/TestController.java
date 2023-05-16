package com.example.javafullcourse.swagger;

import com.example.javafullcourse.learnNaverMail.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final EmailSender emailSender;

    @GetMapping
    public void test() {
        System.out.println("test===");
        emailSender.sendEmil();
    }
}
