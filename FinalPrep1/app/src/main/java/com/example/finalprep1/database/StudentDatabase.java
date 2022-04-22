package com.example.finalprep1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finalprep1.entity.Student;
import com.example.finalprep1.interfaces.StudentDao;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
