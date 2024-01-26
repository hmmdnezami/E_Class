package com.learning.EdLearn.controllers;

import com.learning.EdLearn.models.OptionCheck;
import com.learning.EdLearn.models.Teacher;
import com.learning.EdLearn.repository.TeacherRepo;
import com.learning.EdLearn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public List<Teacher> findAllTeachers(){
        return this.teacherRepo.findAll();
    }

    @GetMapping("/teacher/{teacherId}")
    public Optional<Teacher> findTeacherById(@PathVariable Integer teacherId) {
        return this.teacherRepo.findById(teacherId) ;
    }

    @DeleteMapping("/teacher/{teacherId}")
    public void deleteTeacherById(@PathVariable Integer teacherId) {
        this.teacherRepo.deleteById(teacherId);
        return ;
    }
    @PostMapping("/teacher/check/{roomId}/{studentId}")
    public List<OptionCheck> evaluateStudentTest(@PathVariable String roomId,@PathVariable int studentId) {
        return this.teacherService.evaluateStudentTest(roomId,studentId);
    }

}
