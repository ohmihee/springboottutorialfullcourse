package com.example.javafullcourse.learnNaverMail;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SmsRequest {
    String type; //
    String contentType;
    String from;
    String content;
    List<Messages> messages;

}
