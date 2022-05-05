package com.example.rahuld_3175final;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CourseEntity.class},version = 1,exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {

    public abstract CourseDao courseDao();
}
