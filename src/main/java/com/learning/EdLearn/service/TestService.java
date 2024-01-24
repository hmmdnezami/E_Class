package com.learning.EdLearn.service;
import com.learning.EdLearn.models.Question;
import com.learning.EdLearn.models.Test;
import com.learning.EdLearn.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepo testRepository;

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public Optional<Test> getTestById(Long testId) {
        return testRepository.findById(testId);
    }

    public Test createTest(Test test) {
        // Implement logic to create a new test
        return testRepository.save(test);
    }

    public Test updateTest(Long testId, Test updatedTest) {
        // Implement logic to update an existing test
        return testRepository.save(updatedTest);
    }

    public void deleteTest(Long testId) {
        // Implement logic to delete a test
        testRepository.deleteById(testId);
    }

    public Test addQuestion(String roomId,Question question) {
        Optional<Test> testOptional = testRepository.findByRoomId(roomId);

        if (testOptional.isPresent()) {
            Test test = testOptional.get();
            test.getQuestions().add(question);
            return testRepository.save(test);
        } else {
            return null;
        }
    }

    public void setQuestionsAndAnswers(Long testId, List<Question> questions) {
    }
}
