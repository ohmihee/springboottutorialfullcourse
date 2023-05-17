package com.example.javafullcourse.learnNaverMail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Messages {
    String to; // 발신번호
    String content; // 내용
}
