package com.learning.EdLearn.repository;
import com.learning.EdLearn.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepo extends JpaRepository<Test, Long> {
    Optional<Test> findByRoomId(String roomId);
}
