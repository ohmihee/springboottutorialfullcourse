package com.example.javafullcourse.swagger;

import com.example.javafullcourse.learnNaverMail.EmailSender;
import com.example.javafullcourse.learnNaverMail.SmsSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final SmsSender smsSender;
    @GetMapping
    public void test() {
        smsSender.sendSms();
    }
}
