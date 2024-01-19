package com.learning.EdLearn.controllers;


import com.learning.EdLearn.models.Student;
import com.learning.EdLearn.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return this.studentRepo.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Integer studentId) {
        return this.studentRepo.findById(studentId);
    }

}
