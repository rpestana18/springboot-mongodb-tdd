package com.pestana.springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "test")
public class Student {

    @Id
    private String id;
    private String name;
    private String score;

    public Student() {
    }

    public Student(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student[id=%s, name='%s', score='%s']", id, name, score);
    }
}
