package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo  extends JpaRepository<StudentResult, Integer> {
}
