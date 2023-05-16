package com.example.javafullcourse.learnNaverMail;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailForm {
    String senderAddress;
    String senderName;

    String title;
    String body;

}
