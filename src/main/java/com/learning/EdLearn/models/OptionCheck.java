package com.learning.EdLearn.models;


import jakarta.persistence.*;

@Entity
@Table(name = "option_check")
public class OptionCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question ;

    private boolean flag ;
    private String correctAnswer;

    @ManyToOne
    private StudentResult studentResult;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean check) {
        this.flag = check;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public OptionCheck(String question, boolean flag, String correctAnswer) {
        this.question = question;
        this.flag = flag;
        this.correctAnswer = correctAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public OptionCheck(boolean flag, String correctAnswer) {
        this.flag = flag;
        this.correctAnswer = correctAnswer;
    }
}
