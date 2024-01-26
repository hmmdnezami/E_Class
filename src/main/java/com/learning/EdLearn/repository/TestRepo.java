package com.learning.EdLearn.repository;

import com.learning.EdLearn.models.Discussion;
import com.learning.EdLearn.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {

    Test findByRoomID(String roomID);
}