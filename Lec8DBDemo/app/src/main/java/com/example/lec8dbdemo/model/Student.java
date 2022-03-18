package com.example.lec8dbdemo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STUDENTS")
public class Student {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "studentid")
    String studentId;
    @ColumnInfo(name = "studentname")
    String studentName;
    @ColumnInfo(name = "studentdept")
    String studentDept;

    public Student(@NonNull String studentId, String studentName, String studentDept) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDept = studentDept;
    }

    public Student() {
        //if the parameter names in constructor does not match
    }

    @NonNull
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }
}
