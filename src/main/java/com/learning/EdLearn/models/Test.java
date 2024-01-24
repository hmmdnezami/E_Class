package com.learning.EdLearn.models;
import com.learning.EdLearn.models.Question;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Test {
    @Id
    private Long id;
    private String roomId;
    private String dateTime;

   @OneToMany
    private List<Question> questions=new ArrayList<>();
    @OneToMany
    private List<Student> students=new ArrayList<>();

    public String getRoomId() {
        return roomId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Student> getStudents() {
        return students;
    }

}
