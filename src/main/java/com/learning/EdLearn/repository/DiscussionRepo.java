package com.learning.EdLearn.repository;
import com.learning.EdLearn.models.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepo extends JpaRepository<Discussion, Long> {
    Discussion findByRoomID(String roomID);
}