package com.learning.EdLearn.service;

import com.learning.EdLearn.models.User;
import com.learning.EdLearn.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //load user from database

        User user = this.userRepo.findByEmail(username).orElseThrow(()-> new RuntimeException("user not found"));

        return user;
    }
}
