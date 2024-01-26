package com.learning.EdLearn.models;

public class OptionCheck {

    private String question ;

    private boolean check ;
    private String correctAnswer;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public OptionCheck(String question, boolean check, String correctAnswer) {
        this.question = question;
        this.check = check;
        this.correctAnswer = correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public OptionCheck(boolean check, String correctAnswer) {
        this.check = check;
        this.correctAnswer = correctAnswer;
    }
}