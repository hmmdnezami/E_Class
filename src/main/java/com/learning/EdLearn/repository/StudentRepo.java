package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.Student;
import com.learning.EdLearn.models.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findById(int id);
}
