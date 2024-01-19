package com.learning.EdLearn.controllers;

import com.learning.EdLearn.models.*;
import com.learning.EdLearn.repository.StudentRepo;
import com.learning.EdLearn.repository.SuperUserRepo;
import com.learning.EdLearn.repository.TeacherRepo;
import com.learning.EdLearn.repository.UserRepo;
import com.learning.EdLearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private StudentRepo studentRepo ;

    @Autowired
    private TeacherRepo teacherRepo ;

    @Autowired
    private SuperUserRepo superUserRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return this.userService.getAll();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return this.userRepo.findById(userId) ;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        User user1 = this.userRepo.save(user);
        String email = user.getEmail();
        String name = user.getName();
        UserRole userRole1 = user.getUserRole();
        if (userRole1.equals(UserRole.STUDENT)) {
            Student student = new Student(name, email) ;
            this.studentRepo.save(student);
        }
        else if  (userRole1.equals(UserRole.TEACHER)) {
            Teacher teacher = new Teacher(name, email) ;
            this.teacherRepo.save(teacher) ;
        }
        else {
            SuperUser superUser = new SuperUser(name, email) ;
            this.superUserRepo.save(superUser);
        }
        return user1 ;
    }




}