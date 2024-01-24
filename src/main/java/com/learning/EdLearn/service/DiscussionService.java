package com.learning.EdLearn.service;

import com.learning.EdLearn.models.Discussion;
import com.learning.EdLearn.repository.DiscussionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepo discussionRepository;

    public Discussion createDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    public Discussion getDiscussionByRoomId(String roomId) {
        return discussionRepository.findByRoomID(roomId);
    }

    public Discussion updateDiscussion(String roomId, Discussion updatedDiscussion) {
        Discussion existingDiscussion = discussionRepository.findByRoomID(roomId);

        if (existingDiscussion != null) {
            // Update fields based on your needs
            existingDiscussion.setName(updatedDiscussion.getName());
            existingDiscussion.setEmail(updatedDiscussion.getEmail());
            existingDiscussion.setGoogleMeetLink(updatedDiscussion.getGoogleMeetLink());
            existingDiscussion.setDateTime(updatedDiscussion.getDateTime());
            existingDiscussion.setStudents(updatedDiscussion.getStudents());

            return discussionRepository.save(existingDiscussion);
        } else {
            return null;
        }
    }

    public boolean deleteDiscussion(String roomId) {
        Discussion discussion = discussionRepository.findByRoomID(roomId);
        if (discussion != null) {
            discussionRepository.delete(discussion);
            return true;
        } else {
            return false;
        }
    }
}
