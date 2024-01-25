package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepo extends JpaRepository<Questions, Long> {
}
