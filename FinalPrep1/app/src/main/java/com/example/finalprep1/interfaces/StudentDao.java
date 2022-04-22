package com.example.finalprep1.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalprep1.entity.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudents(List<Student> students);

    @Query("SELECT * FROM Student")
    List<Student> getAllStudnetsFromDB();
}
