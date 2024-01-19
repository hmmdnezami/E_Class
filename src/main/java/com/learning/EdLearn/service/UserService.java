package com.learning.EdLearn.service;

import com.learning.EdLearn.models.User;
import com.learning.EdLearn.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo ;

    public List<User> getAll() {
        return this.userRepo.findAll();
    }
}
