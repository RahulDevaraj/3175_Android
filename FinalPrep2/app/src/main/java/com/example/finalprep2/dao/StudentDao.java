package com.example.finalprep2.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalprep2.entities.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudent(Student student);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudents(List<Student> students);

    @Query("SELECT * FROM STUDENTS")
    List<Student> getAllData();

    @Query("DELETE FROM STUDENTS WHERE studentId = :stdId")
    int deleteWithId(String stdId);

    @Query("SELECT * FROM STUDENTS WHERE studentId LIKE '3%'")
    List<Student> getStudentsStartingWith3();

    @Query("DELETE FROM STUDENTS WHERE studentId LIKE '3%'")
    int deleteStudentsStartingWith3();

    @Delete
    int deleteStudent(Student student);

}
