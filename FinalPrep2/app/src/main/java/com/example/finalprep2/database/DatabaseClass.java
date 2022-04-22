package com.example.finalprep2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finalprep2.dao.StudentDao;
import com.example.finalprep2.entities.Student;

@Database(entities = Student.class,version = 2,exportSchema = false)
public abstract class DatabaseClass extends RoomDatabase {
    public abstract StudentDao studentDao();
}
