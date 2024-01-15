package com.learning.EdLearn.controllers;

import com.learning.EdLearn.models.User;
import com.learning.EdLearn.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepo ;

    @GetMapping("/user/")
    private List<User> getUsers() {
        return userRepo.findAll();
    }

}
