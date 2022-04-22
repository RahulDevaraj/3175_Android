package com.example.finalprep1.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @ColumnInfo(name = "studentid")
    @NonNull
    @PrimaryKey
    String id;
    @ColumnInfo(name = "studentname")
    String name;
    @ColumnInfo(name = "coursename")
    String course;

    public Student(@NonNull String id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Student() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
