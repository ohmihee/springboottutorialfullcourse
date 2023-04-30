package com.example.springboottutorialfullcourse.student.controller;

import com.example.springboottutorialfullcourse.student.entity.Student;
import com.example.springboottutorialfullcourse.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findStudents () {
        return this.studentService.findStudents();
    }

    @GetMapping("/{id}")
    public Student findStudent (@PathVariable Long id) {
        return this.studentService.findStudent(id);
    }

    @PostMapping("/join")
    public void createStudent (@RequestBody Student student) {
        this.studentService.createStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deletedStudent(@PathVariable("studentId") Long stduentId) {
        this.studentService.removeStudent(stduentId);
    }

    @PutMapping(path ="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false)String email) {
        this.studentService.updateStudent(studentId, name, email);
    }
}
