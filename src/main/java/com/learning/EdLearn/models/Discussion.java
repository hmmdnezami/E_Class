package com.learning.EdLearn.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String email;

    @Column(unique = true)
    private String roomID;

    private String googleMeetLink;

    private String dateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "discussion_id")
    private List<Student> students;



    public Discussion(String name, String email, String roomID, String googleMeetLink, String dateTime, List<Student> students) {
        this.name = name;
        this.email = email;
        this.roomID = roomID;
        this.googleMeetLink = googleMeetLink;
        this.dateTime = dateTime;
        this.students = students;
    }

    public Discussion() {

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

    public String getGoogleMeetLink() {
        return googleMeetLink;
    }

    public void setGoogleMeetLink(String googleMeetLink) {
        this.googleMeetLink = googleMeetLink;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}