package com.example.springboottutorialfullcourse.config;

import com.example.springboottutorialfullcourse.store.StudentRepository;
import com.example.springboottutorialfullcourse.student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student test1 = new Student(
                    1L,
                    "test",
                    "test",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Student test2 = new Student(
                    1L,
                    "test",
                    "test",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            repository.saveAll(List.of(test1, test2));
        };
    }
}
