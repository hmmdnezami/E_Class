package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepo extends JpaRepository<Student, Integer> {
}
