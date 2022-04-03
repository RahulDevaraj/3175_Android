package com.example.lec8dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lec8dbdemo.model.Grade;
import com.example.lec8dbdemo.model.Student;

import java.util.List;

@Dao
public interface GradeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGrade(Grade grade);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGrades(List<Grade> gradeList);

    @Query("SELECT * FROM GRADES")
    List<Grade> getAllGrades();

    @Query("SELECT * FROM GRADES WHERE studentid IN (:stdIds)")
    List<Grade> getGradesFromStudentIds(List<String> stdIds);

    @Query("UPDATE GRADES SET studentgrade = 1.1*studentgrade WHERE studentid = :stdId")
    int increaseGradeForOneStudent(String stdId);

    @Query("UPDATE GRADES SET studentgrade = 1.1*studentgrade WHERE studentid IN (:stdId) AND courseid = :courseId")
    int increaseGradesForStudentsInCourse(List<String> stdId,String courseId);


}
