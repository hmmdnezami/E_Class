package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email) ;
}
