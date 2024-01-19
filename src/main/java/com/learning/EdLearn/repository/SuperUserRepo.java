package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.SuperUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperUserRepo extends JpaRepository<SuperUser, Integer> {
}
