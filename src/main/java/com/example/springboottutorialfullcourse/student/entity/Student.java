package com.example.springboottutorialfullcourse.student;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String id;
    private String name;
    private LocalDate dob;
    private Integer age;
}
