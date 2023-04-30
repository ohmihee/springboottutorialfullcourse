package com.example.springboottutorialfullcourse.student.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence", sequenceName = "stduent_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();

    }
}
