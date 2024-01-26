package com.learning.EdLearn.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question ;

    @JsonProperty("questionOptionsList")
    private List<String> questionOptionsList = new ArrayList<>() ;

    private String correctAnswer ;

    private  String selectedOption ;

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Questions(Long id, String question, List<String> questionOptionsList, String correctAnswer, Test test) {
        this.id = id;
        this.question = question;
        this.questionOptionsList = questionOptionsList;
        this.correctAnswer = correctAnswer;
        this.test = test;
    }

    public Questions() {
    }

    public Questions(String question, List<String> questionOptionsList, String correctAnswer) {
        this.question = question;
        this.questionOptionsList = questionOptionsList;
        this.correctAnswer = correctAnswer;
    }

    public Questions(String question, List<String> questionOptionsList) {
        this.question = question;
        this.questionOptionsList = questionOptionsList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getQuestionOptionsList() {
        return questionOptionsList;
    }

    public void setQuestionOptionsList(List<String> questionOptionsList) {
        this.questionOptionsList = questionOptionsList;
    }

    public Questions(Long id, String question, List<String> questionOptionsList, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.questionOptionsList = questionOptionsList;
        this.correctAnswer = correctAnswer;
    }
}