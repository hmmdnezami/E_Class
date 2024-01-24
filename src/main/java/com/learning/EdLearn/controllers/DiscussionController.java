package com.learning.EdLearn.controllers;
import com.learning.EdLearn.models.Discussion;
import com.learning.EdLearn.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping("/")
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion) {
        Discussion createdDiscussion = discussionService.createDiscussion(discussion);
        return ResponseEntity.ok(createdDiscussion);
    }

    @GetMapping("/{roomId}")
    public String getDiscussion(@PathVariable String roomId) {
        Discussion discussion = discussionService.getDiscussionByRoomId(roomId);
        if (discussion != null) {
            return discussion.getGoogleMeetLink();
        } else {
            return "NULL";
        }
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Discussion> updateDiscussion(@PathVariable String roomId, @RequestBody Discussion updatedDiscussion) {
        Discussion discussion = discussionService.updateDiscussion(roomId, updatedDiscussion);
        if (discussion != null) {
            return ResponseEntity.ok(discussion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable String roomId) {
        boolean deleted = discussionService.deleteDiscussion(roomId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
