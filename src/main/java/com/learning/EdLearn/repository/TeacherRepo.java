package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
