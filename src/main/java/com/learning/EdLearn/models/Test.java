package com.learning.EdLearn.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String email;

    @Column(unique = true)
    private String roomID;

    private String testLink;

    private String dateTime;

    private List<Questions> questionsList = new ArrayList<>();

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getTestLink() {
        return testLink;
    }

    public void setTestLink(String testLink) {
        this.testLink = testLink;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    public Test(String name, String email, String roomID, String testLink, String dateTime, List<Questions> questionsList) {
        this.name = name;
        this.email = email;
        this.roomID = roomID;
        this.testLink = testLink;
        this.dateTime = dateTime;
        this.questionsList = questionsList;
    }
}
