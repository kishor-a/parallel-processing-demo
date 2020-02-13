package com.akishor;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String score;
    private String major;

    public Student(String name, String score, String major) {
        this.name = name;
        this.score = score;
        this.major = major;
    }

}
