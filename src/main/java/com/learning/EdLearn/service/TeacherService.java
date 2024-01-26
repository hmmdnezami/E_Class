package com.learning.EdLearn.service;

import com.learning.EdLearn.models.*;
import com.learning.EdLearn.repository.StudentRepo;
import com.learning.EdLearn.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private StudentRepo studentRepo;
    public List<OptionCheck> evaluateStudentTest(String roomId, int studentId) {
        Test test = testRepo.findByRoomID(roomId);
        Student student = studentRepo.findById(studentId);

        if (test != null && student != null) {
            List<StudentAnswer> studentAnswers = student.getStudentAnswers();

            List<OptionCheck> optionChecks = new ArrayList<>();
            int score = 0;

            for (StudentAnswer studentAnswer : studentAnswers) {
                Questions question = studentAnswer.getQuestion();
                String que = question.getQuestion();
                String selectedOption = studentAnswer.getSelectedOption();
                String correctOption = question.getCorrectAnswer();
                boolean flag = selectedOption != null && selectedOption.equals(correctOption);

                if (flag) {
                    score++;
                }

                OptionCheck o = new OptionCheck(que, flag, correctOption);
                optionChecks.add(o);
            }

            saveScoreAndFeedback(student, test.getId(), score, "Provide feedback here");
            return optionChecks;
        }

        return Collections.emptyList();
    }

    public void saveScoreAndFeedback(Student student, Long testId, int score, String feedback) {
        if (student != null) {
            student.setScore(score);
            student.setFeedback(feedback);
            studentRepo.save(student);
        }
    }
}
