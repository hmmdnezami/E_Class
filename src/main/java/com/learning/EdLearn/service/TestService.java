package com.learning.EdLearn.service;

import com.learning.EdLearn.models.Questions;
import com.learning.EdLearn.models.StudentResult;
import com.learning.EdLearn.models.Test;
import com.learning.EdLearn.models.OptionCheck;
import com.learning.EdLearn.repository.ResultRepo;
import com.learning.EdLearn.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepo testRepo;

    @Autowired
    ResultRepo resultRepo;

    public List<Questions> getTestQuestion(String roomId) {
        Test test = testRepo.findByRoomID(roomId);
        List<Questions> questions = new ArrayList<>();
        for (Questions q : test.getQuestionsList()) {
            String que = q.getQuestion();
            List<String> option = q.getQuestionOptionsList();
            Questions newQuestion = new Questions(que, option);
            questions.add(newQuestion);
        }
        return questions;
    }

    public StudentResult checkTestQuestion(String roomId, Test test, String studentId) {
        List<Questions> questions = new ArrayList<>();
        List<OptionCheck>optionChecks = new ArrayList<>();
        for (Questions q : test.getQuestionsList()) {
            String que = q.getQuestion();
            String selectedOption = q.getSelectedOption();
            String correctOption = q.getCorrectAnswer();
            boolean flag = selectedOption != null && selectedOption.equals(correctOption);
            OptionCheck o = new OptionCheck(que, flag,correctOption);
            optionChecks.add(o);
        }
        StudentResult studentResult = new StudentResult();
        studentResult.setOptionChecks(optionChecks);
        studentResult.setRoomId(roomId);
        studentResult.setStudentId(studentId);
        resultRepo.save(studentResult);
        return studentResult;
    }

}
