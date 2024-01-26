package com.learning.EdLearn.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentAnswer> studentAnswers = new ArrayList<>();
    private int score;
    private String feedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<StudentAnswer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
