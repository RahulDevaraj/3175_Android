package com.example.finalprep2.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STUDENTS")
public class Student {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "studentId")
    String studentId;

    @NonNull
    @ColumnInfo(name = "studentName")
    String studentName;

    @NonNull
    @ColumnInfo(name = "studentDept")
    String studentDept;

    public Student(@NonNull String studentId, @NonNull String studentName, @NonNull String studentDept) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDept = studentDept;
    }

    public Student() {
    }

    @NonNull
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull String studentId) {
        this.studentId = studentId;
    }

    @NonNull
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(@NonNull String studentName) {
        this.studentName = studentName;
    }

    @NonNull
    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(@NonNull String studentDept) {
        this.studentDept = studentDept;
    }
}
