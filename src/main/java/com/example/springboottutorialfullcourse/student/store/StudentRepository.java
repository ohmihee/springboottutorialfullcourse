package com.example.springboottutorialfullcourse.student.store;

import com.example.springboottutorialfullcourse.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("SELECT S FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
