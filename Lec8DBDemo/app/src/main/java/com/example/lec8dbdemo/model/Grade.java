package com.example.lec8dbdemo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "GRADES",primaryKeys = {"courseid","studentid"},
        foreignKeys = @ForeignKey(entity = Student.class,
                parentColumns = "studentid",
                childColumns = "studentid",
                onDelete = ForeignKey.CASCADE))
public class Grade {
    @ColumnInfo(name = "courseid")
    @NonNull
    String courseId;

    @ColumnInfo(name = "studentid")
    @NonNull
    String studentId;

    @ColumnInfo(name = "studentgrade")
    Double studentGrade;

    public Grade(@NonNull String courseId, @NonNull String studentId, Double studentGrade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.studentGrade = studentGrade;
    }

    public Grade() {
    }

    @NonNull
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(@NonNull String courseId) {
        this.courseId = courseId;
    }

    @NonNull
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(@NonNull String studentId) {
        this.studentId = studentId;
    }

    public Double getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Double studentGrade) {
        this.studentGrade = studentGrade;
    }
}
