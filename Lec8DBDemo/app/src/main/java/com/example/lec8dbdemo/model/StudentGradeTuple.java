package com.example.lec8dbdemo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class StudentGradeTuple {
    @ColumnInfo(name = "studentname")
    @NonNull
    String studentName;

    @ColumnInfo(name = "studentgrade")
    @NonNull
    Double studentGrade;

    @NonNull
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(@NonNull String studentName) {
        this.studentName = studentName;
    }

    @NonNull
    public Double getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(@NonNull Double studentGrade) {
        this.studentGrade = studentGrade;
    }
}
