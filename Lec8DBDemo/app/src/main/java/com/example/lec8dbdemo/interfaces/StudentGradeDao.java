package com.example.lec8dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.lec8dbdemo.model.StudentGradeTuple;

import java.util.List;

@Dao
public interface StudentGradeDao {
    @Query("SELECT studentname, studentgrade FROM STUDENTS INNER JOIN GRADES " +
            "WHERE STUDENTS.studentid = GRADES.studentid")
    List<StudentGradeTuple> getStudentsNameAndGrades();

    @Query("SELECT studentname, studentgrade FROM STUDENTS INNER JOIN GRADES " +
            "WHERE STUDENTS.studentid = GRADES.studentid " +
            "AND studentgrade > :gradeThreshold")
    List<StudentGradeTuple> getStudentsNameAndGradesWithHighGrades(double gradeThreshold);
}
