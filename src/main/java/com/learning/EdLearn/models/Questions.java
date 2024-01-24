package com.learning.EdLearn.models;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Questions {

    String question ;
    List<Options> optionsList = new ArrayList<>() ;

    String correctAnswer ;

    public Questions() {
    }

    public Questions(String question, List<Options> optionsList, String correctAnswer) {
        this.question = question;
        this.optionsList = optionsList;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
