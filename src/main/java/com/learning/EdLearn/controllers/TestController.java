package com.learning.EdLearn.controllers;


import com.learning.EdLearn.models.Questions;
import com.learning.EdLearn.models.StudentResult;
import com.learning.EdLearn.models.Test;
import com.learning.EdLearn.repository.TestRepo;
import com.learning.EdLearn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private TestService testService;

    @GetMapping("/tests")
    public List<Test> getAllTests() {
        return testRepo.findAll();
    }

    @PostMapping("/tests")
    public Test addTests(@RequestBody Test test) {
        List <Questions> questionsList= test.getQuestionsList();
        System.out.println(questionsList);
        return testRepo.save(test);
    }

    @GetMapping("/tests/{roomId}")
    public List<Questions> getTestsForRoomID(@PathVariable String roomId){
        return this.testService.getTestQuestion(roomId);
    }

    @PostMapping("/tests/check/{roomId}/{studentId}")
    public StudentResult questionCheck(@PathVariable String roomId, @RequestBody Test test, @PathVariable String studentId ) {
            return this.testService.checkTestQuestion(roomId, test,studentId);
    }

}
