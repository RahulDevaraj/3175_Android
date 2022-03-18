package com.example.lec8dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lec8dbdemo.model.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudents(Student... students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertStudentsFromList(List<Student> students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneStudent(Student student);

    @Query("SELECT * FROM STUDENTS")
    List<Student> getAllStudents();

    @Query("SELECT * FROM STUDENTS WHERE studentid IN (:StdIds)")
    List<Student> getStudentsInfoFromIds(List<String> StdIds);
}
