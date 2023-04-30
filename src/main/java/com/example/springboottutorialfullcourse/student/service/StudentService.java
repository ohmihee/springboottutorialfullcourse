package com.example.springboottutorialfullcourse.student.service;

import com.example.springboottutorialfullcourse.student.store.StudentRepository;
import com.example.springboottutorialfullcourse.student.entity.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findStudents () {
        return this.studentRepository.findAll();
//        return List.of(
//                new Student(null, "mihee", "mihee@naver.com",LocalDate.of(2023, Month.FEBRUARY, 5), 28)
//        );
    }
    public Student findStudent (Long id) {
        return this.studentRepository.findById(id).orElseGet(null);
        //return new Student(null, "mihee", "mihee@naver.com",LocalDate.of(2023, Month.FEBRUARY, 5), 28);
    }

//    public Student findStudentByEmail (Student student) {
//        Optional<Student> studentByEmail =  this.studentRepository.findStudentByEmail(student.getEmail());
//        if (studentByEmail.isPresent()) {
//            throw new IllegalStateException("email taken");
//        }
//    }

    public void createStudent (Student student) {
        optionalStudent(student);
        this.studentRepository.save(student);
    }

    public Optional<Student> optionalStudent (Student student) {
        Optional<Student> studentByEmail =  this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return studentByEmail;
    }
    public void removeStudent(Long studentId) {
        boolean exists = this.studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("studentId is not exist"+studentId);
        }
        this.studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("sudent with id " + studentId + "does not exist"));

        if (name != null && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
            Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
        }

    }
}
