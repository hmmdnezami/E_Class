package com.learning.EdLearn.models;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_result")
public class StudentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String studentId;

    private String roomId;

    @OneToMany(mappedBy = "studentResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OptionCheck> optionChecks = new ArrayList<>();


    public StudentResult() {
    }

    public int getId() {
        return id;
    }

    public String getRoomId() {
        return roomId;
    }

    public StudentResult(int id, @NonNull String studentId, String roomId, List<OptionCheck> optionChecks) {
        this.id = id;
        this.studentId = studentId;
        this.roomId = roomId;
        this.optionChecks = optionChecks;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull String studentId) {
        this.studentId = studentId;
    }

    public List<OptionCheck> getOptionChecks() {
        return optionChecks;
    }



    public void setOptionChecks(List<OptionCheck> optionChecks) {
        this.optionChecks = optionChecks;
    }
}
